import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static final int dx[] = {-1, 0, 1, 0};
	static final int dy[] = {0, -1, 0, 1};

	static int N;
	static int[][] cave;
	static boolean[][] visited;
	static int[][] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int cnt = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0) {
				break;
			}

			cave = new int[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			dijkstra();

			sb.append("Problem " + cnt++ + ": " + dist[N - 1][N - 1]).append("\n");
		}

		System.out.println(sb.toString());
		br.close();
	}

	static void dijkstra() {
		//배열의 모든 값을 무한으로 초기화
		dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}

		//초기값 세팅
		dist[0][0] = cave[0][0];

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, 0, cave[0][0]));

		//다익스트라 알고리즘 실행
		while (!pq.isEmpty()) {
			Node n = pq.poll();
			visited[n.y][n.x] = true;

			for (int i = 0; i < 4; i++) {
				int nextY = n.y + dy[i];
				int nextX = n.x + dx[i];
				if (0 <= nextY && nextY < N && 0 <= nextX && nextX < N && !visited[nextY][nextX]
					&& n.cost + cave[nextY][nextX] < dist[nextY][nextX]) {
					dist[nextY][nextX] = n.cost + cave[nextY][nextX];
					pq.add(new Node(nextY, nextX, dist[nextY][nextX]));
				}
			}
		}
	}
}

class Node implements Comparable<Node> {
	int y;
	int x;
	int cost;

	public Node(int y, int x, int cost) {
		this.y = y;
		this.x = x;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.cost, o.cost);
	}
}