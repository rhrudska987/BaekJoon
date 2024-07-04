import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] dist;
	static List<ArrayList<Node>> graph = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph.get(start).add(new Node(end, cost));
		}

		int[] result = new int[N + 1];

		//X에서 각자 집으로 가는 최단경로 계산 
		setting();
		dijkstra(X);
		for (int i = 1; i <= N; i++) {
			result[i] += dist[i];
		}

		//각자 집에서 X로 가는 최단경로 계산
		for (int i = 1; i <= N; i++) {
			setting();
			dijkstra(i);
			result[i] += dist[X];
		}

		int maxTime = 0;
		for (int i = 1; i <= N; i++) {
			maxTime = Math.max(maxTime, result[i]);
		}

		System.out.println(maxTime);
		br.close();
	}

	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		dist[start] = 0;
		pq.add(new Node(start, 0));
		while (!pq.isEmpty()) {
			Node curNode = pq.poll();

			if (dist[curNode.idx] < curNode.cost) {
				continue;
			}

			for (int i = 0; i < graph.get(curNode.idx).size(); i++) {
				Node nextNode = graph.get(curNode.idx).get(i);
				if (dist[nextNode.idx] > dist[curNode.idx] + nextNode.cost) {
					dist[nextNode.idx] = dist[curNode.idx] + nextNode.cost;
					pq.add(new Node(nextNode.idx, dist[nextNode.idx]));
				}
			}
		}
	}

	static void setting() {
		dist = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
	}

	static class Node {
		int idx;
		int cost;

		Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}
}
