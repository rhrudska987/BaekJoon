import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] graph;

	public static void main(String[] args) throws IOException {
		input();
		floydWarshall();
		int cnt = countStudents();
		printAnswer(cnt);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new int[N + 1][N + 1];
		initGraph();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = 1;
		}

		br.close();
	}

	private static void initGraph() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				graph[i][j] = 10000;

				if (i == j) {
					graph[i][j] = 0;
				}
			}
		}
	}

	private static void floydWarshall() {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}
	}

	private static int countStudents() {
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			boolean b = true;
			for (int j = 1; j <= N; j++) {
				if (graph[i][j] == 10000 && graph[j][i] == 10000) {
					b = false;
					break;
				}
			}

			if (b) {
				cnt++;
			}
		}

		return cnt;
	}

	private static void printAnswer(int cnt) {
		System.out.println(cnt);
	}
}
