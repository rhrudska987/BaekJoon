import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		char value;
		Node left;
		Node right;
		
		public Node(char value) {
			this.value = value;
			left = null;
			right = null;
		}
	}
	
	static Node[] tree;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		tree = new Node[N + 1];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char parent = st.nextToken().charAt(0);
			char leftChild = st.nextToken().charAt(0);
			char rightChild = st.nextToken().charAt(0);
			
			if (tree[parent - 'A'] == null) {
				tree[parent - 'A'] = new Node(parent);
			}
			
			if (leftChild != '.') {
				tree[leftChild - 'A'] = new Node(leftChild);
				tree[parent - 'A'].left = tree[leftChild - 'A'];
			}
			
			if (rightChild != '.') {
				tree[rightChild - 'A'] = new Node(rightChild);
				tree[parent - 'A'].right = tree[rightChild - 'A'];
			}
		}
		
		preOrder(tree[0]);
		sb.append("\n");
		inOrder(tree[0]);
		sb.append("\n");
		postOrder(tree[0]);
		
		System.out.println(sb.toString());
		br.close();
	}
	
	static void preOrder(Node node) {
		if (node == null) {
			return;
		}
		sb.append(node.value);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	static void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		sb.append(node.value);
		inOrder(node.right);
	}
	
	static void postOrder(Node node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		sb.append(node.value);
	}
		
}
