import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int[] dx = {-1, 0, 1, 0};
	static final int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			String[] s = br.readLine().split("");
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(s[j - 1]);
			}
		}

		int minDist = Integer.MAX_VALUE;
		boolean[][][] visited = new boolean[N + 1][M + 1][2];

		Queue<Block> q = new LinkedList<>();
		q.add(new Block(1, 1, 1, false));
		while (!q.isEmpty()) {
			Block b = q.poll();
			if (b.x == M && b.y == N) {
				minDist = Math.min(minDist, b.dist);
			}

			for (int i = 0; i < 4; i++) {
				int nextX = b.x + dx[i];
				int nextY = b.y + dy[i];

				if (nextX > 0 && nextX <= M && nextY > 0 && nextY <= N) {
					if (map[nextY][nextX] == 1) {
						if (!b.breakWall) {
							q.add(new Block(nextX, nextY, b.dist + 1, true));
							visited[nextY][nextX][1] = true;
						}
					} else {
						if (!b.breakWall && !visited[nextY][nextX][0]) {
							q.add(new Block(nextX, nextY, b.dist + 1, b.breakWall));
							visited[nextY][nextX][0] = true;
						} else if (b.breakWall && !visited[nextY][nextX][1]) {
							q.add(new Block(nextX, nextY, b.dist + 1, b.breakWall));
							visited[nextY][nextX][1] = true;
						}
					}
				}
			}
		}

		if (minDist == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(minDist);
		}
		br.close();
	}

	static class Block {
		int x;
		int y;
		int dist;
		boolean breakWall;

		Block(int x, int y, int dist, boolean breakWall) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.breakWall = breakWall;
		}
	}

}
