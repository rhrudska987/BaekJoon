import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Main {
	
	static class TrieNode {
		Map<Character, TrieNode> children = new HashMap<>();
		TrieNode failLink;
		List<String> output = new ArrayList<>();
	}
	
	static TrieNode rootNode = new TrieNode();
	
	static void insertKeyword(String keyword) {
		TrieNode curNode = rootNode;
		
		for (char c : keyword.toCharArray()) {
			if (!curNode.children.containsKey(c)) {
				curNode.children.put(c, new TrieNode());
			}
			curNode = curNode.children.get(c);
		}
		
		curNode.output.add(keyword);
	}
	
	static void makeFailLink() {
		Queue<TrieNode> q = new LinkedList<>();
		rootNode.failLink = rootNode;
		
		for (TrieNode child : rootNode.children.values()) {
			child.failLink = rootNode;
			q.add(child);
		}
		
		while (!q.isEmpty()) {
			TrieNode curNode = q.poll();
			
			for (Map.Entry<Character, TrieNode> entry : curNode.children.entrySet()) {
				char c = entry.getKey();
				TrieNode child = entry.getValue();
				q.add(child);
				
				TrieNode failNode = curNode.failLink;
				
				while (failNode != rootNode && !failNode.children.containsKey(c)) {
					failNode = failNode.failLink;
				}
				
				if (failNode.children.containsKey(c)) {
					child.failLink = failNode.children.get(c);
				} else {
					child.failLink = rootNode;
				}
				
				child.output.addAll(child.failLink.output);
			}
			
		}
		
	}
	
	static Set<String> search(String text) {
		Set<String> result = new HashSet<>();
		TrieNode curNode = rootNode;
		
		for (char c : text.toCharArray()) {
			while (curNode != rootNode && !curNode.children.containsKey(c)) {
				curNode = curNode.failLink;
			}
			
			if (curNode.children.containsKey(c)) {
				curNode = curNode.children.get(c);
			} else {
				curNode = rootNode;
			}
			result.addAll(curNode.output);
		}
		
		return result;
	}

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			insertKeyword(br.readLine());
		}
		
		makeFailLink();
		
		int Q = Integer.parseInt(br.readLine());
		for (int i = 0; i < Q; i++) {
			if (search(br.readLine()).size() > 0) {
				sb.append("YES").append("\n");
			} else {
				sb.append("NO").append("\n");
			}
		}
		
		System.out.println(sb.toString());
		br.close();
    }
	
}
