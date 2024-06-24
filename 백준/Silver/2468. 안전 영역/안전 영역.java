import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static boolean[][] visited;
	static int N;
	static int max = Integer.MIN_VALUE;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		int high = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				high = Math.max(high, map[i][j]);
			}
		}

		for (int i = 0; i <= high; i++) {
			int cnt = 0;
			visited = new boolean[N][N];
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (map[j][k] <= i || visited[j][k]) {
						continue;
					}
					dfs(j, k, i);
					cnt++;
				}
			}
			max = Math.max(max, cnt);
		}

		System.out.println(max);
	}

	static void dfs(int y, int x, int rain) {
		for (int i = 0; i < 4; i++) {
			int nextY = y + dy[i];
			int nextX = x + dx[i];
			if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= N || visited[nextY][nextX]
				|| map[nextY][nextX] <= rain) {
				continue;
			}
			visited[nextY][nextX] = true;
			dfs(nextY, nextX, rain);
		}
	}

}
