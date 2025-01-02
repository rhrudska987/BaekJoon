import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		Trie trie = new Trie();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			String[] foods = new String[K];
			for (int j = 0; j < K; j++) {
				foods[j] = st.nextToken();
			}

			trie.insert(foods);
		}

		trie.drawTrie();
	}

	static class TrieNode {
		HashMap<String, TrieNode> children = new HashMap<>();
		boolean isEnd = false;
	}

	static class Trie {
		TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public void insert(String[] foods) {
			TrieNode cur = root;

			for (String food : foods) {
				if (!cur.children.containsKey(food)) {
					cur.children.put(food, new TrieNode());
				}
				cur = cur.children.get(food);
			}

			cur.isEnd = true;
		}

		public void drawTrie() {
			dfs(root, 0);
			System.out.println(sb);
		}

		public void dfs(TrieNode curNode, int depth) {
			if (curNode.isEnd) {
				return;
			}

			List<String> keySet = new ArrayList<>(curNode.children.keySet());
			Collections.sort(keySet);

			for (String food : keySet) {
				drawDepth(depth);
				sb.append(food + "\n");
				dfs(curNode.children.get(food), depth + 1);
			}
		}

		public void drawDepth(int depth) {
			for (int i = 0; i < depth; i++) {
				sb.append("--");
			}
		}

	}

}
