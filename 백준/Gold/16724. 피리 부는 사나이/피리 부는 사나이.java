import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static char[][] map;
	static boolean[][] visited;
	static boolean[][] finished;
	static int safeZoneCnt = 0;

	public static void main(String[] args) throws Exception {
		readInput();
		findSafeZone();
		printAnswer();
	}

	private static void readInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited = new boolean[N][M];
		finished = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		br.close();
	}

	private static void findSafeZone() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j]) {
					continue;
				}

				dfs(i, j);
			}
		}
	}

	private static void dfs(int y, int x) {
		visited[y][x] = true;

		int ny = y;
		int nx = x;
		switch (map[y][x]) {
			case 'U':
				ny--;
				break;
			case 'D':
				ny++;
				break;
			case 'L':
				nx--;
				break;
			case 'R':
				nx++;
				break;
		}

		if (!visited[ny][nx]) {
			dfs(ny, nx);
		} else {
			if (!finished[ny][nx]) {
				safeZoneCnt++;
			}
		}

		finished[y][x] = true;
	}

	static void printAnswer() {
		System.out.println(safeZoneCnt);
	}

}
