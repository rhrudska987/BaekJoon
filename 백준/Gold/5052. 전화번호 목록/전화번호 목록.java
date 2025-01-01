import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			Trie trie = new Trie();

			int n = Integer.parseInt(br.readLine());
			String[] telephoneNumber = new String[n];
			for (int i = 0; i < n; i++) {
				telephoneNumber[i] = br.readLine();
			}

			boolean result = true;
			for (int i = 0; i < n; i++) {
				if (!trie.insert(telephoneNumber[i])) {
					result = false;
					break;
				}
			}

			if (result) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		}

		System.out.println(sb);
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

		public boolean insert(String word) {
			TrieNode cur = root;
			for (char c : word.toCharArray()) {
				if (!cur.children.containsKey(c)) {
					cur.children.put(c, new TrieNode());
				}

				if (cur.isEndOfWord) {
					return false;
				}

				cur = cur.children.get(c);
			}
			cur.isEndOfWord = true;
			if (cur.children.size() > 0) {
				return false;
			}
			return true;
		}

	}

}
