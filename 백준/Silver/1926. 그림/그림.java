import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m, cnt = 0, maxSize = 0;
	static int pictureSize = 0;
	static int[][] paper;
	static boolean[][] visited;
	static Queue<int[]> q = new LinkedList<>();

	static final int dx[] = {-1, 0, 1, 0};
	static final int dy[] = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		readInput();
		findPicture();
		printAnswer();
	}

	static void readInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		visited = new boolean[n][m];
		paper = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());

				if (paper[i][j] == 1) {
					q.add(new int[] {i, j});
				}
			}
		}
	}

	static void findPicture() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && paper[i][j] == 1) {
					cnt++;
					pictureSize = 0;

					dfs(i, j);

					if (pictureSize > maxSize) {
						maxSize = pictureSize;
					}
				}
			}
		}
	}

	private static void dfs(int y, int x) {
		visited[y][x] = true;
		pictureSize++;

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[ny][nx] || paper[ny][nx] == 0) {
				continue;
			}

			dfs(ny, nx);
		}
	}

	static void printAnswer() {
		System.out.println(cnt);
		System.out.println(maxSize);
	}

}
