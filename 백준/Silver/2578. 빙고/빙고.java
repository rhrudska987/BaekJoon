import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		board = new int[5][5];
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;

		end: for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				eraseNum(Integer.parseInt(st.nextToken()));
				
				if (i * 5 + (j + 1) < 12) {
					continue;
				}
				
				if (bingoCheck() >= 3) {
					ans = i * 5 + (j + 1);
					break end;
				}
			}
		}

		System.out.println(ans);
		br.close();
	}

	static void eraseNum(int num) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (board[i][j] == num) {
					board[i][j] = 0;
					return;
				}
			}
		}
	}

	static int bingoCheck() {
		int cnt = 0;

		//행 빙고 확인
		for (int i = 0; i < 5; i++) {
			int zeroCnt = 0;
			for (int j = 0; j < 5; j++) {
				if (board[i][j] == 0) {
					zeroCnt++;
				}
			}

			if (zeroCnt == 5) {
				cnt++;
			}
		}

		//열 빙고 확인
		for (int i = 0; i < 5; i++) {
			int zeroCnt = 0;
			for (int j = 0; j < 5; j++) {
				if (board[j][i] == 0) {
					zeroCnt++;
				}
			}

			if (zeroCnt == 5) {
				cnt++;
			}
		}

		//기울기가 음수인 대각선 빙고 확인
		if (board[0][0] == 0 && board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] == board[3][3] && board[3][3] == board[4][4]) {
			cnt++;
		}
		
		//기울기가 양수인 대각선 빙고 확인
		if (board[0][4] == 0 && board[0][4] == board[1][3] && board[1][3] == board[2][2] && board[2][2] == board[3][1] && board[3][1] == board[4][0]) {
			cnt++;
		}

		return cnt;
	}
}
