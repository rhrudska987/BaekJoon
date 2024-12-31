import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Trie trie = new Trie();
		for (int i = 0; i < N; i++) {
			trie.insert(br.readLine());
		}

		int answer = 0;
		for (int i = 0; i < M; i++) {
			if (trie.isPrefix(br.readLine())) {
				answer++;
			}
		}

		System.out.println(answer);
		br.close();
	}

	static class TrieNode {
		HashMap<Character, TrieNode> children = new HashMap<>();
		boolean isEndOfWord = false;
	}

	static class Trie {
		TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public void insert(String word) {
			TrieNode cur = root;
			for (char c : word.toCharArray()) {
				if (!cur.children.containsKey(c)) {
					cur.children.put(c, new TrieNode());
				}

				cur = cur.children.get(c);
			}
			cur.isEndOfWord = true;
		}

		public boolean isPrefix(String prefix) {
			TrieNode cur = root;
			for (char c : prefix.toCharArray()) {
				if (cur.children.containsKey(c)) {
					cur = cur.children.get(c);
				} else {
					return false;
				}
			}
			return true;
		}

	}

}
