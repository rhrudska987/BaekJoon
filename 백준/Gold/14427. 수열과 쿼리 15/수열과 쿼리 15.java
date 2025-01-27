import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int S = 1;
	static int[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		while (S < N) {
			S *= 2;
		}
		tree = new int[S * 2 + 1];

		for (int i = 0; i < S * 2; i++) {
			tree[i] = 1000000000;
		}

		String[] s = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			tree[S + i] = Integer.parseInt(s[i]);
			update((S + i) / 2);
		}

		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			String input = br.readLine();
			if (input.length() != 1) {
				String[] c = input.split(" ");
				int idx = Integer.parseInt(c[1]) + S - 1;
				int number = Integer.parseInt(c[2]);
				tree[idx] = number;
				update(idx / 2);
			} else {
				int num = find(1, S, 1, tree[1]);
				sb.append((num - S + 1) + "\n");
			}
		}

		System.out.println(sb);
		br.close();
	}

	private static int find(int left, int right, int idx, int num) {
		int mid = (left + right) / 2;
		if (left == right) {
			return idx;
		}
		if (tree[idx * 2] == num) {
			return find(left, mid, idx * 2, num);
		} else {
			return find(mid + 1, right, idx * 2 + 1, num);
		}
	}

	private static void update(int idx) {
		if (idx <= 0) return;
		int leftIdx = (idx * 2);
		int rightIdx = (idx * 2) + 1;

		tree[idx] = Math.min(tree[leftIdx], tree[rightIdx]);
		update(idx / 2);
	}

}
