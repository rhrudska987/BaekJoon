import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		ArrayList<Node>[] graph = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph[A].add(new Node(B, 1));
		}

		boolean[] visited = new boolean[N+1];
		int[] dist = new int[N+1];

		for (int i = 0; i <= N; i++) {
			dist[i] = 3000001;
		}

		dist[X] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(X, 0));

		while (!pq.isEmpty()) {
			int curVertex = pq.poll().idx;

			if (visited[curVertex]) {
				continue;
			}
			visited[curVertex] = true;

			for (Node next : graph[curVertex]) {
				if (dist[next.idx] > dist[curVertex] + next.cost) {
					dist[next.idx] = dist[curVertex] + next.cost;
				}
				pq.offer(new Node(next.idx, dist[next.idx]));
			}
		}

		boolean find = false;
		for (int i = 1; i <= N; i++) {
			if (dist[i] == K) {
				System.out.println(i);
				find = true;
			}
		}

		if (!find) {
			System.out.println(-1);
		}
	}

	static class Node implements Comparable<Node> {
		int idx;
		int cost;

		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

}
