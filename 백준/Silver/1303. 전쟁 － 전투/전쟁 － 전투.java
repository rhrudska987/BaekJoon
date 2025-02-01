import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static char[][] soldiers;
	static boolean[][] visited;
	static int cnt;
	static int totalWhite = 0;
	static int totalBlue = 0;

	static final int[] dx = {-1, 0, 1, 0};
	static final int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[M][N];
		soldiers = new char[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			soldiers[i] = st.nextToken().toCharArray();
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j]) {
					continue;
				}

				cnt = 1;
				dfs(soldiers[i][j], i, j);

				if (soldiers[i][j] == 'W') {
					totalWhite += cnt * cnt;
				} else {
					totalBlue += cnt * cnt;
				}
			}
		}

		System.out.println(totalWhite + " " + totalBlue);
		br.close();
	}

	static void dfs(char color, int y, int x) {
		visited[y][x] = true;

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny < 0 || ny >= M || nx < 0 || nx >= N || visited[ny][nx] || soldiers[ny][nx] != color) {
				continue;
			}

			cnt++;
			dfs(color, ny, nx);
		}
	}

}
