import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] board;
	static int minusCnt = 0;
	static int zeroCnt = 0;
	static int plusCnt = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dq(0, 0, N);

		System.out.println(minusCnt);
		System.out.println(zeroCnt);
		System.out.println(plusCnt);
		br.close();
	}

	static void dq(int x, int y, int n) {
		boolean isSame = true;
		end: for (int i = y; i < y + n; i++) {
			for (int j = x; j < x + n; j++) {
				if (board[i][j] != board[y][x]) {
					dq(x, y, n / 3);
					dq(x, y + n / 3, n / 3);
					dq(x, y + (n / 3) * 2, n / 3);
					dq(x + n / 3, y, n / 3);
					dq(x + (n / 3) * 2, y, n / 3);
					dq(x + n / 3, y + n / 3, n / 3);
					dq(x + (n / 3) * 2, y + n / 3, n / 3);
					dq(x + n / 3, y + (n / 3) * 2, n / 3);
					dq(x + (n / 3) * 2, y + (n / 3) * 2, n / 3);
					isSame = false;
					break end;
				}
			}
		}

		if (isSame) {
			if (board[y][x] == -1) {
				minusCnt++;
			} else if (board[y][x] == 0) {
				zeroCnt++;
			} else {
				plusCnt++;
			}
		}
		return;
	}

}
