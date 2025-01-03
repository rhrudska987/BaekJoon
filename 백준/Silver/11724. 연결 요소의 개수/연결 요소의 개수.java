import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] line;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		line = new int[N + 1][N + 1];
		visited = new boolean[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			line[u][v] = line[v][u] = 1;
		}

		int answer = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (line[i][j] == 1 && !visited[i][j]) {
					answer++;
					dfs(i, j);
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			boolean isAlone = true;
			for (int j = 1; j <= N; j++) {
				if (line[i][j] == 1) {
					isAlone = false;
					break;
				}
			}
			if (isAlone) {
				answer++;
			}
		}

		System.out.println(answer);
		br.close();
	}

	static void dfs(int u, int v) {
		visited[u][v] = true;
		visited[v][u] = true;
		for (int i = 1; i <= N; i++) {
			if (line[v][i] == 1 && !visited[v][i]) {
				dfs(v, i);
			}
		}
		for (int i = 1; i <= N; i++) {
			if (line[u][i] == 1 && !visited[u][i]) {
				dfs(u, i);
			}
		}
	}

}
