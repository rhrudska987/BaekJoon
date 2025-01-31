import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static String[][] space;
	static boolean[][] visited;
	static int sheep, wolf;
	static int totalSheep = 0;
	static int totalWolf = 0;

	static final int[] dx = {-1, 0, 1, 0};
	static final int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		space = new String[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			space[i] = br.readLine().split("");
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!visited[i][j] && space[i][j].equals(".")) {
					visited[i][j] = true;
					sheep = 0;
					wolf = 0;
					dfs (i, j);
					if (sheep > wolf) {
						totalSheep += sheep;
					} else {
						totalWolf += wolf;
					}
				} else if (!visited[i][j] && space[i][j].equals("o")) {
					visited[i][j] = true;
					sheep = 1;
					wolf = 0;
					dfs (i, j);
					if (sheep > wolf) {
						totalSheep += sheep;
					} else {
						totalWolf += wolf;
					}
				} else if (!visited[i][j] && space[i][j].equals("v")) {
					visited[i][j] = true;
					sheep = 0;
					wolf = 1;
					dfs (i, j);
					if (sheep > wolf) {
						totalSheep += sheep;
					} else {
						totalWolf += wolf;
					}
				}

			}
		}

		System.out.println(totalSheep + " " + totalWolf);
		br.close();
	}

	static void dfs (int y, int x) {
		for (int k = 0; k < 4; k++) {
			int ny = y + dy[k];
			int nx = x + dx[k];

			if (ny < 0 || ny >= R || nx < 0 || nx >= C || visited[ny][nx] || space[ny][nx].equals("#")) {
				continue;
			}

			visited[ny][nx] = true;
			if (space[ny][nx].equals("o")) {
				sheep++;
			} else if (space[ny][nx].equals("v")) {
				wolf++;
			}

			dfs(ny, nx);
		}
	}

}
