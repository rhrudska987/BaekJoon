import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[][] forest;
	static int[][] dp;
	static boolean[][] visited;
	static int max = 0;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine());
		forest = new int[n][n];
		dp = new int[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				forest[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = 1;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dfs(j, i);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				max = Math.max(max, dp[i][j]);
			}
		}

		System.out.println(max);
		br.close();
	}

	static int dfs(int x, int y) {
		if (visited[y][x]) {
			return dp[y][x];
		}

		visited[y][x] = true;
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= n || ny >= n || forest[y][x] >= forest[ny][nx]) {
				continue;
			}

			cnt = Math.max(cnt, dfs(nx, ny));
		}

		dp[y][x] += cnt;
		return dp[y][x];
	}

}
