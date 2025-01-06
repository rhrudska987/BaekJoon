import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int M, N, K, board[][];
	static boolean visited[][];
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		board = new int[M][N];
		visited = new boolean[M][N];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int leftX = Integer.parseInt(st.nextToken());
			int leftY = Integer.parseInt(st.nextToken());
			int rightX = Integer.parseInt(st.nextToken());
			int rightY = Integer.parseInt(st.nextToken());
			for (int j = leftY; j < rightY; j++) {
				for (int k = leftX; k < rightX; k++) {
					board[j][k] = 1;
				}
			}
		}

		List<Integer> list = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 0 && !visited[i][j]) {
					list.add(bfs(new int[] {i, j}));
				}
			}
		}

		Collections.sort(list);

		System.out.println(list.size());
		for (int i : list) {
			System.out.print(i + " ");
		}

		br.close();
	}

	static int bfs(int[] startPoint) {
		Queue<int[]> q = new LinkedList<>();
		visited[startPoint[0]][startPoint[1]] = true;
		q.add(new int[] {startPoint[0], startPoint[1]});

		int result = 1;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = cur[0] + dy[i];
				int nx = cur[1] + dx[i];

				if (ny < 0 || ny >= M || nx < 0 || nx >= N || visited[ny][nx] || board[ny][nx] == 1) {
					continue;
				}

				visited[ny][nx] = true;
				q.add(new int[] {ny, nx});
				result++;
			}
		}

		return result;
	}

}
