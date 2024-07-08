import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int[] dx = {-1, 0, 1, 0};
	static final int[] dy = {0, -1, 0, 1};

	static int N, M;
	static int[][] lab;
	static ArrayDeque<int[]> virusStartQ = new ArrayDeque<>();
	static int safeCnt = 0;
	static int ans = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		lab = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());

				if (lab[i][j] == 2) {
					virusStartQ.add(new int[] {i, j});
				} else if (lab[i][j] == 0) {
					safeCnt++;
				}
			}
		}

		buildWall(0, 0);

		System.out.println(ans);
		br.close();
	}

	static void buildWall(int cnt, int y) {
		if (cnt == 3) {
			spreadVirus();
			return;
		}

		for (int i = y; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (lab[i][j] == 0) {
					lab[i][j] = 1;
					buildWall(cnt + 1, i);
					lab[i][j] = 0;
				}
			}
		}
	}

	static void spreadVirus() {
		int[][] lab_clone = new int[N][M];
		for (int i = 0; i < N; i++) {
			lab_clone[i] = Arrays.copyOf(lab[i], M);
		}

		int virusCnt = 0;
		ArrayDeque<int[]> virusQ = new ArrayDeque<>(virusStartQ);
		while (!virusQ.isEmpty()) {
			int[] curVirus = virusQ.poll();

			for (int i = 0; i < 4; i++) {
				int nextY = curVirus[0] + dy[i];
				int nextX = curVirus[1] + dx[i];

				if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N && lab_clone[nextY][nextX] == 0) {
					lab_clone[nextY][nextX] = 2;
					virusQ.add(new int[] {nextY, nextX});
					virusCnt++;
				}
			}
		}

		calcSafeCnt(virusCnt);
	}

	static void calcSafeCnt(int virusCnt) {
		ans = Math.max(ans, safeCnt - virusCnt - 3);
	}

}
