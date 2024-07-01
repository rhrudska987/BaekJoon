import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int[] dx = {-1, 0, 1, 0};
	static final int[] dy = {0, -1, 0, 1};

	static int R, C, K;
	static char map[][];
	static boolean visited[][];
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		visited = new boolean[R][C];
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			char[] c = br.readLine().toCharArray();
			
			for (int j = 0; j < C; j++) {
				map[i][j] = c[j];
			}
		}

		visited[R - 1][0] = true;
		dfs(R - 1, 0, 1);

		System.out.println(answer);
		br.close();
	}

	static void dfs(int curY, int curX, int distance) {
		if (curY == 0 && curX == C - 1) {
			if (distance == K) {
				answer++;
			}
			return;
		}

		for (int i = 0; i < 4; i++) {
			int ny = curY + dy[i];
			int nx = curX + dx[i];

			if (ny < 0 || ny >= R || nx < 0 || nx >= C || visited[ny][nx] || map[ny][nx] == 'T') {
				continue;
			}

			visited[ny][nx] = true;
			dfs(ny, nx, distance + 1);
			visited[ny][nx] = false;
		}

	}

}