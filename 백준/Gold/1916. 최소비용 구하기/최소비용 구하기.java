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
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		setting();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph.get(from).add(new Node(to, cost));
		}

		st = new StringTokenizer(br.readLine());
		int departure = Integer.parseInt(st.nextToken());
		int destination = Integer.parseInt(st.nextToken());

		dijkstra(departure);
		
		System.out.println(dist[destination]);
		br.close();
	}

	static void setting() {
		dist = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
			graph.add(new ArrayList<>());
		}
	}

	static void dijkstra(int departure) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		dist[departure] = 0;
		pq.add(new Node(departure, 0));

		while (!pq.isEmpty()) {
			Node curNode = pq.poll();
			int curCity = curNode.idx;
			int cost = curNode.cost;

			if (dist[curNode.idx] < cost) {
				continue;
			}

			for (int i = 0; i < graph.get(curCity).size(); i++) {
				Node nextNode = graph.get(curCity).get(i);
				if (dist[nextNode.idx] > dist[curCity] + nextNode.cost) {
					dist[nextNode.idx] = dist[curCity] + nextNode.cost;
					pq.add(new Node(nextNode.idx, dist[curCity] + nextNode.cost));
				}
			}
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
