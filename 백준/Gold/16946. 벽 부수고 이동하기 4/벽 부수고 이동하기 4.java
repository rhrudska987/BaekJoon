import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static int[][] territory;
	static boolean[][] visited;
	static Map<Integer, Integer> space = new HashMap<>();

	static final int[] dx = {-1, 0, 1, 0};
	static final int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws Exception {
		readInput();
		connectTerritory();
		calcMoveBlockCnt();
		printAnswer();
	}

	private static void readInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split("");

			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}

		br.close();
	}

	private static void connectTerritory() {
		territory = new int[N][M];
		visited = new boolean[N][M];

		int idx = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j] || map[i][j] == 1) {
					continue;
				}

				space.put(idx, 1);

				dfs (i, j, idx);
				idx++;
			}
		}
	}

	private static void dfs(int y, int x, int idx) {
		territory[y][x] = idx;
		visited[y][x] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (isNotSatisfiedConditions(ny, nx)) {
				continue;
			}

			space.put(idx, space.get(idx) + 1);
			dfs(ny, nx, idx);
		}
	}

	private static boolean isNotSatisfiedConditions(int y, int x) {
		if (x < 0 || x >= M || y < 0 || y >= N || visited[y][x] || map[y][x] == 1) {
			return true;
		}

		return false;
	}

	private static void calcMoveBlockCnt() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (territory[i][j] == 0) {
					map[i][j] = addBlockCnt(i, j);
				}
			}
		}
	}

	private static int addBlockCnt(int y, int x) {
		Set<Integer> set = new HashSet<>();

		int cnt = 1;
		for (int k = 0; k < 4; k++) {
			int ny = y + dy[k];
			int nx = x + dx[k];

			if (nx < 0 || nx >= M || ny < 0 || ny >= N || territory[ny][nx] == 0 || set.contains(territory[ny][nx])) {
				continue;
			}

			cnt += space.get(territory[ny][nx]);
			set.add(territory[ny][nx]);
		}

		return cnt;
	}

	private static void printAnswer() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j] % 10);
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

}
