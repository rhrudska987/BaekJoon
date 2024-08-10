import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class  Main {

	static int N, M, K;
	static char[][] board;
	static int[][] cntBoard;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		cntBoard = new int[N + 1][M + 1];
		board = new char[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			for (int j = 1; j <= M; j++) {
				board[i][j] = s.charAt(j - 1);
			}
		}

		countingBoard('B');

		//행 더하기
		for (int i = 1; i <= N; i++) {
			for (int j = 2; j <= M; j++) {
				cntBoard[i][j] += cntBoard[i][j - 1];
			}
		}
		//열 더하기
		for (int j = 1; j <= M; j++) {
			for (int i = 2; i <= N; i++) {
				cntBoard[i][j] += cntBoard[i - 1][j];
			}
		}

		for (int i = K; i <= N; i++) {
			for (int j = K; j <= M; j++) {
				min = Math.min(min,
					cntBoard[i][j] - (cntBoard[i - K][j] + cntBoard[i][j - K] - cntBoard[i - K][j - K]));
			}
		}

		countingBoard('W');

		//행 더하기
		for (int i = 1; i <= N; i++) {
			for (int j = 2; j <= M; j++) {
				cntBoard[i][j] += cntBoard[i][j - 1];
			}
		}
		//열 더하기
		for (int j = 1; j <= M; j++) {
			for (int i = 2; i <= N; i++) {
				cntBoard[i][j] += cntBoard[i - 1][j];
			}
		}

		for (int i = K; i <= N; i++) {
			for (int j = K; j <= M; j++) {
				min = Math.min(min,
					cntBoard[i][j] - (cntBoard[i - K][j] + cntBoard[i][j - K] - cntBoard[i - K][j - K]));
			}
		}

		System.out.println(min);
		br.close();
	}

	static void countingBoard(char firstBlock) {
		char[][] tmpBoard = new char[N + 1][M + 1];
		tmpBoard[1][1] = firstBlock;
		for (int i = 1; i <= N; i++) {
			if (i != 1) {
				tmpBoard[i][1] = (tmpBoard[i - 1][1] == 'B') ? 'W' : 'B';
			}
			for (int j = 2; j <= M; j++) {
				tmpBoard[i][j] = (tmpBoard[i][j - 1] == 'B') ? 'W' : 'B';
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				cntBoard[i][j] = (board[i][j] != tmpBoard[i][j]) ? 1 : 0;
			}
		}
	}

}

