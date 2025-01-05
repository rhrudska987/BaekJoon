import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int[] parent = new int[N + 1];
		boolean[] visited = new boolean[N + 1];

		ArrayList<Integer>[] connections = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			connections[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			connections[a].add(b);
			connections[b].add(a);
		}

		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int child : connections[cur]) {
				if (visited[child]) {
					continue;
				}
				
				q.add(child);
				visited[child] = true;
				parent[child] = cur;
			}
		}

		for (int i = 2; i <= N; i++) {
			System.out.println(parent[i]);
		}

	}

}
