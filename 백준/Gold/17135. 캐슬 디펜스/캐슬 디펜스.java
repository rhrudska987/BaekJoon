import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, D;
	static int[][] board;
	static int[] archer = new int[3];
	static int maxCnt = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		comb(0, 0);

		System.out.println(maxCnt);
		br.close();
	}

	static void comb(int cnt, int idx) {
		if (cnt == 3) {
			maxCnt = Math.max(maxCnt, fight());
			return;
		}

		for (int i = idx; i < M; i++) {
			archer[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}

	static int fight() {
		int cnt = 0;
		int[][] status = new int[N][M];

		for (int line = N; line > 0; line--) {
			for (int pick : archer) {
				for (int d = 1; d <= D; d++) {
					int result = attack(status, pick, d, line);
					if (result < 0) {
						continue;
					}
					cnt += result;
					break;
				}
			}
		}

		return cnt;
	}

	static int attack(int[][] status, int pick, int d, int line) {
		int y;
		for (int x = pick - d; x <= pick + d; x++) {
			y = line - (d - Math.abs(x - pick));
			if (x < 0 || x >= M || y < 0 || y >= line || board[y][x] == 0) {
				continue;
			}

			if (status[y][x] == 0) {
				status[y][x] = line;
				return 1;
			} else if (status[y][x] == line) {
				return 0;
			}
		}

		return -1;
	}

}
