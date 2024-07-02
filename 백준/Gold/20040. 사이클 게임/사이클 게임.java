import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		int cnt = 0;
		boolean circulate = false;
		for (int i = 0; i < m; i++) {
			cnt++;
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if (!union(x, y)) {
				circulate = true;
				break;
			}
		}

		if (circulate) {
			System.out.println(cnt);
		} else {
			System.out.println(0);
		}

		br.close();
	}

	static int find(int x) {
		if (parent[x] == x) {
			return x;
		}

		return find(parent[x]);
	}

	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y) {
			return false;
		}

		if (x < y) {
			parent[y] = x;
		} else {
			parent[x] = y;
		}
		return true;
	}

}
