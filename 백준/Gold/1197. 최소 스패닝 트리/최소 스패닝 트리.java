import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] parent;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();

		parent = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}

		int[][] graph = new int[E][3];
		for (int i = 0; i < E; i++) {
			graph[i][0] = sc.nextInt();
			graph[i][1] = sc.nextInt();
			graph[i][2] = sc.nextInt();
		}

		Arrays.sort(graph, (o1, o2) -> o1[2] - o2[2]);

		long cost = 0;
		for (int i = 0; i < E; i++) {
			int from = find(graph[i][0]);
			int to = find(graph[i][1]);
			if (from != to) {
				union(from, to);
				cost += graph[i][2];
			}
		}

		System.out.println(cost);
		sc.close();
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

		if (x != y) {
			if (x < y) {
				parent[y] = x;
			} else {
				parent[x] = y;
			}
		}
	}
}
