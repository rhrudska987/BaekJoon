import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] board;
	static Queue<Point> queue = new LinkedList<Point>();
	static int r2, c2;
	static boolean findAnswer = false;

	static int[] dr = {-2, -2, 0, 0, 2, 2};
	static int[] dc = {-1, 1, -2, 2, -1, 1};

	public static void main(String[] args) throws Exception {
		readInput();
		bfs();
		if (!findAnswer) {
			printAnswer(-1);
		}
	}

	private static void readInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		board = new int[N + 1][N + 1];

		st = new StringTokenizer(br.readLine());
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());

		queue.add(new Point(r1, c1, 0));
		board[r1][c1] = 1;
		br.close();
	}

	private static void bfs() {
		while (!queue.isEmpty()) {
			Point p = queue.poll();

			for (int i = 0; i < dr.length; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];

				if (nr < 0 || nr > N || nc < 0 || nc > N || board[nr][nc] == 1) {
					continue;
				}

				if (nr == r2 && nc == c2) {
					printAnswer(p.moveCount + 1);
					findAnswer = true;
					return;
				}

				queue.add(new Point(nr, nc, p.moveCount + 1));
				board[nr][nc] = 1;
			}
		}
	}

	private static void printAnswer(int answer) {
		System.out.println(answer);
	}

	private static class Point {
		int r;
		int c;
		int moveCount;

		public Point(int r, int c, int moveCount) {
			this.r = r;
			this.c = c;
			this.moveCount = moveCount;
		}
	}

}
