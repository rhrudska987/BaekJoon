import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static final int NUMBER_OF_PRINCESS = 7;
	static final int GRID_SIZE = 5;
	static final int[] dx = {-1, 0, 1, 0};
	static final int[] dy = {0, -1, 0, 1};

	static int yCnt = 0;
	static char[][] seats = new char[GRID_SIZE][GRID_SIZE];
	static boolean[] visited = new boolean[GRID_SIZE * GRID_SIZE];
	static int answer = 0;

	public static void main(String[] args) throws Exception {
		readInput();
		permutation(0, 0);
		printAnswer();
	}

	private static void printAnswer() {
		System.out.println(answer);
	}

	private static void readInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < GRID_SIZE; i++) {
			seats[i] = br.readLine().toCharArray();
		}

		br.close();
	}

	private static void permutation(int idx, int princessCnt) {
		if (yCnt >= 4) {
			return;
		}

		if (princessCnt == NUMBER_OF_PRINCESS) {
			int lastIdx = idx - 1;
			int y = lastIdx / 5;
			int x = lastIdx % 5;
			if (bfs(y, x)) {
				answer++;
			}
			return;
		}

		for (int i = idx; i < GRID_SIZE * GRID_SIZE; i++) {
			int y = i / GRID_SIZE;
			int x = i % GRID_SIZE;

			visited[i] = true;
			if (seats[y][x] == 'Y') {
				yCnt++;
			}

			permutation(i + 1, princessCnt + 1);

			visited[i] = false;
			if (seats[y][x] == 'Y') {
				yCnt--;
			}
		}
	}

	private static boolean bfs(int y, int x) {
		int cnt = 1;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {y, x});
		
		boolean[] visitedCopy = visited.clone();
		visitedCopy[y * GRID_SIZE + x] = false;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int ny = cur[0] + dy[i];
				int nx = cur[1] + dx[i];

				int idx = ny * GRID_SIZE + nx;

				if (isOutOfBounds(nx, ny) || !visited[idx] || !visitedCopy[idx]) {
					continue;
				}

				visitedCopy[idx] = false;
				q.add(new int[] {ny, nx});
				cnt++;
			}
		}

		return cnt == NUMBER_OF_PRINCESS;
	}

	private static boolean isOutOfBounds(int nx, int ny) {
		return nx < 0 || nx >= 5 || ny < 0 || ny >= 5;
	}

}
