import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static final int[] dx = {-1, 0, 1, 0};
	static final int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		List<Pos> cheeseList = new ArrayList<Pos>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					cheeseList.add(new Pos(j, i));
			}
		}

		int times = 0;
		while (!cheeseList.isEmpty()) {
			times++;
			visited = new boolean[N][M];
			airCheck(0, 0);

			for (Pos pos : cheeseList) {
				int cnt = 0;
				for (int j = 0; j < 4; j++) {
					int nx = pos.x + dx[j];
					int ny = pos.y + dy[j];
					if (map[ny][nx] == 0 && visited[ny][nx])
						cnt++;
				}

				if (cnt >= 2) {
					visited[pos.y][pos.x] = true;
				}
			}

			for (int i = 0; i < cheeseList.size(); i++) {
				Pos pos = cheeseList.get(i);
				if (visited[pos.y][pos.x]) {
					map[pos.y][pos.x] = 0;
					cheeseList.remove(i--);
				}
			}

		}

		System.out.println(times);
		br.close();
	}

	static void airCheck(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= M || ny >= N || visited[ny][nx] || map[ny][nx] == 1)
				continue;
			visited[ny][nx] = true;
			airCheck(nx, ny);
		}
	}

	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
