import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int[] dx = {-1, 0, 1, 0};
	static final int[] dy = {0, -1, 0, 1};

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[N][N];
		int idx = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					dfs(j, i, idx);
					idx++;
				}
			}
		}

		for (int i = 1; i < idx; i++) {
			visited = new boolean[N][N];

			Queue<Block> q = new LinkedList<>();
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					if (map[y][x] == i) {
						q.add(new Block(x, y, 0));
					}
				}
			}

			while (!q.isEmpty()) {
				Block block = q.poll();

				for (int j = 0; j < 4; j++) {
					int nx = block.x + dx[j];
					int ny = block.y + dy[j];

					if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[ny][nx] != i && !visited[ny][nx]) {
						if (map[ny][nx] == 0) {
							visited[ny][nx] = true;
							q.add(new Block(nx, ny, block.dist + 1));
						} else {
							min = Math.min(min, block.dist);
						}
					}
				}
			}

		}

		System.out.println(min);
		br.close();
	}

	static void dfs(int x, int y, int idx) {
		visited[y][x] = true;
		map[y][x] = idx;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[ny][nx] && map[ny][nx] == 1) {
				dfs(nx, ny, idx);
			}
		}
	}

	static class Block {
		int x;
		int y;
		int dist;

		public Block(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

}
