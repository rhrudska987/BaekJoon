import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static boolean find = false;
	static int minCnt = 0;
	static char[][] map;
	static Queue<int[]> move = new LinkedList<>();
	static Queue<int[]> water = new LinkedList<>();

	static final int[] dx = {-1, 0, 1, 0};
	static final int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		inputValue();
		bfs();
		printAnswer();
	}

	private static void inputValue() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String inputStr = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = inputStr.charAt(j);

				if (map[i][j] == 'S') {
					move.add(new int[] {i, j});
				} else if (map[i][j] == '*') {
					water.add(new int[] {i, j});
				}

			}
		}

		br.close();
	}

	private static void bfs() {
		while (!move.isEmpty() && !find) {
			waterExtend(water.size());
			minCnt++;
			moveExtend(move.size());
		}
	}

	private static void moveExtend(int moveSize) {
		for (int i = 0; i < moveSize; i++) {
			int[] cur = move.poll();
			int y = cur[0];
			int x = cur[1];

			for (int j = 0; j < 4; j++) {
				int nx = x + dx[j];
				int ny = y + dy[j];
				if (nx < 0 || nx >= C || ny < 0 || ny >= R || map[ny][nx] == 'V' || map[ny][nx] == '*' || map[ny][nx] == 'X') {
					continue;
				}

				if (map[ny][nx] == 'D') {
					find = true;
					break;
				}

				map[ny][nx] = 'V';
				move.add(new int[] {ny, nx});
			}
		}
	}

	private static void waterExtend(int waterSize) {
		for (int i = 0; i < waterSize; i++) {
			int[] cur = water.poll();
			int y = cur[0];
			int x = cur[1];

			for (int j = 0; j < 4; j++) {
				int nx = x + dx[j];
				int ny = y + dy[j];
				if (nx < 0 || nx >= C || ny < 0 || ny >= R || map[ny][nx] == 'D' || map[ny][nx] == 'X' || map[ny][nx] == '*') {
					continue;
				}

				map[ny][nx] = '*';
				water.add(new int[] {ny, nx});
			}
		}
	}

	private static void printAnswer() {
		if (find) {
			System.out.println(minCnt);
		} else {
			System.out.println("KAKTUS");
		}
	}

}
