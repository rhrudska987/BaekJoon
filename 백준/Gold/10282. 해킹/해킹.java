import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			List<Node>[] graph = createGraph(n, d);
			dijkstra(graph, n, c);
		}

		System.out.println(sb);
		br.close();
	}

	private static List<Node>[] createGraph(int n, int d) throws IOException {
		List<Node>[] graph = new List[n + 1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < d; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			graph[b].add(new Node(a, s));
		}

		return graph;
	}

	private static void dijkstra(List<Node>[] graph, int n, int c) {
		boolean[] visited = new boolean[n + 1];
		int[] dist = new int[n + 1];
		initDistArray(dist);

		int infectedCnt = 0;
		dist[c] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(c, 0));

		while (!pq.isEmpty()) {
			int curVertex = pq.poll().idx;

			if (visited[curVertex]) {
				continue;
			}
			visited[curVertex] = true;

			infectedCnt++;

			for (Node next : graph[curVertex]) {
				if (dist[next.idx] > dist[curVertex] + next.cost) {
					dist[next.idx] = dist[curVertex] + next.cost;
				}

				pq.add(new Node(next.idx, dist[next.idx]));
			}
		}

		int maxDist = findMaxDistance(dist);
		sb.append(infectedCnt).append(" ").append(maxDist).append("\n");
	}

	private static void initDistArray(int[] dist) {
		for (int i = 0; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
	}

	private static int findMaxDistance(int[] dist) {
		int maxDistance = 0;
		for (int distance : dist) {
			if (distance != Integer.MAX_VALUE) {
				maxDistance = Math.max(maxDistance, distance);
			}
		}
		return maxDistance;
	}

	private static class Node implements Comparable<Node> {
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
