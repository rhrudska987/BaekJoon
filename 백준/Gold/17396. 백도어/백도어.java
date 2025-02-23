import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static List<Node>[] graph;
	static int[] isViewed;
	static long[] dist;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		readInput();
		dijkstra();
		printAnswer();
	}

	private static void readInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new List[N];
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList();
		}

		isViewed = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			isViewed[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());

			graph[a].add(new Node(b, t));
			graph[b].add(new Node(a, t));
		}

		br.close();
	}

	private static void dijkstra() {
		dist = new long[graph.length];
		for (int i = 0; i < graph.length; i++) {
			dist[i] = Long.MAX_VALUE;
		}

		visited = new boolean[graph.length];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, 0));
		dist[0] = 0;

		while (!pq.isEmpty()) {
			int curVertex = pq.poll().idx;

			if (visited[curVertex]) {
				continue;
			}
			visited[curVertex] = true;

			for (Node next : graph[curVertex]) {
				if (isViewed[next.idx] == 1 && next.idx != N - 1) {
					continue;
				}
				if (dist[next.idx] > dist[curVertex] + next.cost) {
					dist[next.idx] = dist[curVertex] + next.cost;
				}
				pq.add(new Node(next.idx, dist[next.idx]));
			}
		}
	}

	private static void printAnswer() {
		if (dist[N - 1] == Long.MAX_VALUE) {
			System.out.println(-1);
			return;
		}

		System.out.println(dist[N - 1]);
	}

	private static class Node implements Comparable<Node> {
		int idx;
		long cost;

		public Node(int idx, long cost) {
			this.idx = idx;
			this.cost = cost;
		}

		public int compareTo(Node o) {
			if (this.cost - o.cost > 0) {
				return 1;
			}
			return -1;
		}
	}

}
