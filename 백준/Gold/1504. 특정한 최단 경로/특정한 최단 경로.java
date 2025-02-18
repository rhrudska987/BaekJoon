import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, E;
	static List<Node>[] graph;
	static int v1, v2;
	static boolean[] visited;
	static int[] dist;

	public static void main(String[] args) throws Exception {
		readInput();
		int answer = findAnswer();
		printAnswer(answer);
	}

	private static void readInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		initGraph();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new Node(b, c));
			graph[b].add(new Node(a, c));
		}

		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());

		br.close();
	}

	private static void initGraph() {
		graph = new List[N + 1];

		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
	}

	private static int findAnswer() {
		int visitedV1FirstDistance = 0;
		dijkstra(1);
		visitedV1FirstDistance += dist[v1];
		dijkstra(v1);
		visitedV1FirstDistance += dist[v2];
		dijkstra(v2);
		visitedV1FirstDistance += dist[N];

		int visitedV2FirstDistance = 0;
		dijkstra(1);
		visitedV2FirstDistance += dist[v2];
		dijkstra(v2);
		visitedV2FirstDistance += dist[v1];
		dijkstra(v1);
		visitedV2FirstDistance += dist[N];

		return Math.min(visitedV1FirstDistance, visitedV2FirstDistance);
	}

	private static void dijkstra(int startVertex) {
		visited = new boolean[N + 1];
		initDist();

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(startVertex, 0));
		dist[startVertex] = 0;

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
				pq.add(new Node(next.idx, dist[next.idx]));
			}
		}
	}

	private static void initDist() {
		dist = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
	}

	private static void printAnswer(int answer) {
		if (answer > 8000000 || answer < 1) {
			System.out.println(-1);
			return;
		}

		System.out.println(answer);
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
