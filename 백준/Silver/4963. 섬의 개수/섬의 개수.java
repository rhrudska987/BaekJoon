import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static final int dx[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	static final int dy[] = {0, -1, -1, -1, 0, 1, 1, 1};
	static int w;
	static int h;
	static int[][] map;
	static boolean[][] visited;
	static ArrayDeque<int[]> q = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0) {
				break;
			}

			visited = new boolean[h][w];
			map = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						q.add(new int[] {i, j});
					}
				}
			}

			int cnt = 0;
			while (!q.isEmpty()) {
				int[] point = q.poll();
				int y = point[0];
				int x = point[1];
				if (!visited[y][x]) {
					visited[y][x] = true;
					cnt++;
					dfs(y, x);
				}
			}

			sb.append(cnt).append("\n");
		}

		System.out.println(sb.toString());
		br.close();
	}

	static void dfs(int y, int x) {
		for (int i = 0; i < 8; i++) {
			int nextY = y + dy[i];
			int nextX = x + dx[i];
			if (0 <= nextY && nextY < h && 0 <= nextX && nextX < w && !visited[nextY][nextX]
				&& map[nextY][nextX] == 1) {
				visited[nextY][nextX] = true;
				dfs(nextY, nextX);
			}
		}
	}

}
