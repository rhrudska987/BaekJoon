import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int[] dx = {-1, 0, 1, 0};
	static final int[] dy = {0, -1, 0, 1};

	static int N, M, K;
	static int cnt = 0;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 1;
		}

		int max = 0;
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= M; c++) {
				if (map[r][c] == 1 && !visited[r][c]) {
					cnt = 1;
					dfs(r, c);
					max = Math.max(max, cnt);
				}
			}
		}

		System.out.println(max);
	}

	static void dfs(int r, int c) {
		visited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nextR = r + dy[i];
			int nextC = c + dx[i];
			if (nextR > 0 && nextR <= N && nextC > 0 && nextC <= M && !visited[nextR][nextC]
				&& map[nextR][nextC] == 1) {
				cnt++;
				dfs(nextR, nextC);
			}
		}
	}

}
