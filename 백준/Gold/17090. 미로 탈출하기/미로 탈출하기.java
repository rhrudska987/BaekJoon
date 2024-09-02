import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static String[][] map;
	static boolean[][] visited;
	static int cnt = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new String[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().split("");
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (dfs(i, j)) {
					cnt++;
					map[i][j] = "T";
				} else {
					map[i][j] = "F";
				}
			}
		}

		System.out.println(cnt);
		br.close();
	}

	static boolean dfs(int y, int x) {
		if (map[y][x].equals("T")) {
			return true;
		} else if (map[y][x].equals("F")) {
			return false;
		}

		if (visited[y][x]) {
			return false;
		}
		visited[y][x] = true;

		int nextY = y;
		int nextX = x;
		if (map[y][x].equals("U")) nextY = y - 1;
		else if (map[y][x].equals("D")) nextY = y + 1;
		else if (map[y][x].equals("L")) nextX = x - 1;
		else nextX = x + 1;

		if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) {
			return true;
		} else {
			if (dfs(nextY, nextX)) {
				map[nextY][nextX] = "T";
				return true;
			} else {
				map[nextY][nextX] = "F";
				return false;
			}
		}
	}

}
