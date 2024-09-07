import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int K, W, H;
	static int[][] board;
	static boolean[][][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int[] horseDx = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] horseDy = {-1, -2, -2, -1, 1, 2, 2, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		board = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[H][W][K + 1];
		ArrayDeque<Block> q = new ArrayDeque<>();
		q.add(new Block(0, 0, 0, 0));
		visited[0][0][0] = true;

		int ans = -1;
		while (!q.isEmpty()) {
			Block block = q.poll();
			
			if (block.x == W - 1 && block.y == H - 1) {
				ans = block.cnt;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nx = block.x + dx[i];
				int ny = block.y + dy[i];

				if (nx >= 0 && nx < W && ny >= 0 && ny < H && !visited[ny][nx][block.horseMoving] && board[ny][nx] != 1) {
					visited[ny][nx][block.horseMoving] = true;
					q.add(new Block(nx, ny, block.cnt + 1, block.horseMoving));
				}
			}

			if (block.horseMoving < K) {
				for (int i = 0; i < 8; i++) {
					int nx = block.x + horseDx[i];
					int ny = block.y + horseDy[i];
					if (nx >= 0 && nx < W && ny >= 0 && ny < H && !visited[ny][nx][block.horseMoving + 1] && board[ny][nx] != 1) {
						visited[ny][nx][block.horseMoving + 1] = true;
						q.add(new Block(nx, ny, block.cnt + 1, block.horseMoving + 1));
					}
				}
			}
		}

		System.out.println(ans);
		br.close();
	}

	static class Block {
		int x, y, cnt, horseMoving;

		Block(int x, int y, int cnt, int horseMoving) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.horseMoving = horseMoving;
		}
	}
}
