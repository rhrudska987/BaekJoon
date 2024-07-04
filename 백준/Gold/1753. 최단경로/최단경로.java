import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V, E;
	static int[] dist;
	static List<ArrayList<Node>> graph = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int startNode = Integer.parseInt(br.readLine());

		setting();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph.get(u).add(new Node(v, w));
		}

		dijkstra(startNode);
		printAnswer();
		br.close();
	}

	static void setting() {
		dist = new int[V + 1];
		for (int i = 0; i <= V; i++) {
			graph.add(new ArrayList<>());
			dist[i] = Integer.MAX_VALUE;
		}
	}

	static void dijkstra(int startNode) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		pq.add(new Node(startNode, 0));
		dist[startNode] = 0;
		while (!pq.isEmpty()) {
			Node curNode = pq.poll();

			if (dist[curNode.num] < curNode.cost) {
				continue;
			}

			for (int i = 0; i < graph.get(curNode.num).size(); i++) {
				Node nextNode = graph.get(curNode.num).get(i);

				if (dist[nextNode.num] > curNode.cost + nextNode.cost) {
					dist[nextNode.num] = curNode.cost + nextNode.cost;
					pq.add(new Node(nextNode.num, dist[nextNode.num]));
				}
			}
		}

	}

	static void printAnswer() {
		for (int i = 1; i <= V; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				sb.append("INF\n");
			} else {
				sb.append(dist[i] + "\n");
			}
		}

		System.out.println(sb.toString());
	}

	static class Node {
		int num;
		int cost;

		Node(int num, int cost) {
			this.num = num;
			this.cost = cost;
		}
	}
}
