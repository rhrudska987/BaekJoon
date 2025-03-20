import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static String[][] map;
	static int[][] dp;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static boolean moveForever = false;
	static int maxMoveCount = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new String[N][M];
		dp = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().split("");
		}

		visited[0][0] = true;
		dfs(0, 0, 1);

		if (moveForever) {
			System.out.println(-1);
		} else {
			System.out.println(maxMoveCount);
		}

		br.close();
	}

	private static void dfs(int y, int x, int moveCount) {
		maxMoveCount = Math.max(maxMoveCount, moveCount);
		dp[y][x] = moveCount;

		for (int i = 0; i < 4; i++) {
			int num = Integer.parseInt(map[y][x]);
			int ny = y + dy[i] * num;
			int nx = x + dx[i] * num;

			if (ny < 0 || ny >= N || nx < 0 || nx >= M || map[ny][nx].equals("H")) {
				continue;
			}

			if (visited[ny][nx]) {
				moveForever = true;
				return;
			}

			if (dp[ny][nx] > moveCount) {
				continue;
			}

			visited[ny][nx] = true;
			dfs(ny, nx, moveCount + 1);
			visited[ny][nx] = false;
		}
	}

}
