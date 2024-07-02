import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static int[] friendCost;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		friendCost = new int[N + 1];
		parent = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			friendCost[i] = Integer.parseInt(st.nextToken());
			parent[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			union(v, w);
		}

		int sum = 0;
		boolean[] visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			if (visited[find(i)]) {
				visited[i] = true;
				continue;
			}

			sum += friendCost[find(i)];
			visited[find(i)] = true;
			visited[i] = true;
		}

		if (sum > k) {
			System.out.println("Oh no");
		} else {
			System.out.println(sum);
		}

		br.close();
	}

	static int find(int x) {
		if (x == parent[x]) {
			return x;
		}

		return find(parent[x]);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (friendCost[x] <= friendCost[y]) {
			parent[y] = x;
		} else {
			parent[x] = y;
		}
	}

}
