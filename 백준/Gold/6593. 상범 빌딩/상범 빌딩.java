import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static final int[] dx = {-1, 0, 1, 0, 0, 0};
	static final int[] dy = {0, -1, 0, 1, 0, 0};
	static final int[] dz = {0, 0, 0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			if (L == 0 && R == 0 && C == 0) {
				break;
			}

			char[][][] building = new char[L][R][C]; // z - x - y 순
			boolean[][][] visited = new boolean[L][R][C];

			Queue<int[]> queue = new LinkedList<>();
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					char[] c = br.readLine().toCharArray();
					for (int k = 0; k < C; k++) {
						building[i][j][k] = c[k];

						if (building[i][j][k] == 'S') {
							queue.add(new int[] {i, j, k, 0});
							visited[i][j][k] = true;
						}
					}
				}
				br.readLine();
			}

			boolean find = false;
			int escapeTime = 0;
			while (!queue.isEmpty()) {
				int[] cur = queue.poll();
				int time = cur[3];

				if (building[cur[0]][cur[1]][cur[2]] == 'E') {
					find = true;
					escapeTime = cur[3];
					break;
				}

				for (int i = 0; i < 6; i++) {
					int nz = cur[0] + dz[i];
					int nx = cur[1] + dx[i];
					int ny = cur[2] + dy[i];

					if (nz < 0 || nz >= L || nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nz][nx][ny]
						|| building[nz][nx][ny] == '#') {
						continue;
					}

					visited[nz][nx][ny] = true;
					queue.add(new int[] {nz, nx, ny, time + 1});
				}

			}

			if (find) {
				sb.append("Escaped in ").append(escapeTime).append(" minute(s).\n");
			} else {
				sb.append("Trapped!\n");
			}
		}

		System.out.println(sb);
		br.close();
	}

}
