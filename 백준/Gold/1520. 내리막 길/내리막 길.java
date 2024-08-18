import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map, dp;
	static final int[] dx = {-1, 0, 1, 0};
	static final int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				dp[i][j] = -1;
			}
		}

		System.out.println(dfs(1, 1));
		br.close();
	}

	static int dfs(int x, int y) {
		if (x == M && y == N) {
			return 1;
		}

		if (dp[y][x] != -1) {
			return dp[y][x];
		}

		dp[y][x] = 0;
		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (nextX > 0 && nextX <= M && nextY > 0 && nextY <= N && map[y][x] > map[nextY][nextX]) {
				dp[y][x] += dfs(nextX, nextY);
			}
		}

		return dp[y][x];
	}

}
