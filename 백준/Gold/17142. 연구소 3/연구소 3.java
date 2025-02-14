import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static final int[] dx = {-1, 0, 1, 0};
	static final int[] dy = {0, -1, 0, 1};

	static int N, M;
	static List<int[]> virusPositionList = new ArrayList<>();
	static int[][] lab;
	static int minTime = Integer.MAX_VALUE;
	static int[] selectedVirus;
	static int totalEmptyBlock;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		totalEmptyBlock = N * N;
		selectedVirus = new int[M];
		lab = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());

				if (lab[i][j] == 2) {
					virusPositionList.add(new int[]{i, j});
				}

				if (lab[i][j] == 1) {
					totalEmptyBlock--;
				}
			}
		}

		combination(0, 0);

		if(minTime == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(minTime);
		}
	}
	
	private static void combination(int idx, int depth) {
		if (depth == M) {
			calcTime();
			return;
		}

		for (int i = idx; i < virusPositionList.size(); i++) {
			selectedVirus[depth] = i;
			combination(i + 1, depth + 1);
		}

	}

	private static void calcTime() {
		int[][] copyLab = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				copyLab[i][j] = lab[i][j];
			}
		}

		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			int[] virusPosition = virusPositionList.get(selectedVirus[i]);
			int y = virusPosition[0];
			int x = virusPosition[1];

			copyLab[y][x] = 3;
			queue.add(new int[]{y, x, 0});
		}

		int cnt = totalEmptyBlock - virusPositionList.size();
		if (cnt == 0) {
			minTime = 0;
		}
		int time = Integer.MAX_VALUE;
		while (!queue.isEmpty()) {
			int[] virusPosition = queue.poll();

			for (int i = 0; i < 4; i++) {
				int ny = virusPosition[0] + dy[i];
				int nx = virusPosition[1] + dx[i];

				if (ny < 1 || ny > N || nx < 1 || nx > N || copyLab[ny][nx] == 1 || copyLab[ny][nx] == 3) {
					continue;
				}

				if (copyLab[ny][nx] == 2) {
					copyLab[ny][nx] = 3;
					queue.add(new int[]{ny, nx, virusPosition[2] + 1});
				} else {
					copyLab[ny][nx] = 3;
					queue.add(new int[]{ny, nx, virusPosition[2] + 1});
					cnt--;
				}

				if (cnt == 0) {
					time = virusPosition[2] + 1;
					minTime = Math.min(time, minTime);
					return;
				}
			}

		}
	}

}
