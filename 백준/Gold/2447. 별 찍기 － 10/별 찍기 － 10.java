import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static String[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		board = new String[N][N];

		divideConquer(0, 0, N);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(board[i][j]);
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
		br.close();
	}

	static void divideConquer(int y, int x, int size) {
		if (size == 3) {
			drawStar(y, x);
			return;
		}

		divideConquer(y, x, size / 3);
		divideConquer(y + size / 3, x, size / 3);
		divideConquer(y + size / 3 * 2, x, size / 3);
		divideConquer(y, x + size / 3, size / 3);
		divideConquer(y, x + size / 3 * 2, size / 3);
		drawSpace(y + size / 3, x + size / 3, size / 3);
		divideConquer(y + size / 3, x + size / 3 * 2, size / 3);
		divideConquer(y + size / 3 * 2, x + size / 3, size / 3);
		divideConquer(y + size / 3 * 2, x + size / 3 * 2, size / 3);
	}

	static void drawStar(int y, int x) {
		for (int j = x; j < x + 3; j++) {
			board[y][j] = "*";
			board[y + 2][j] = "*";
		}

		board[y + 1][x] = "*";
		board[y + 1][x + 1] = " ";
		board[y + 1][x + 2] = "*";
	}

	static void drawSpace(int y, int x, int size) {
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				board[i][j] = " ";
			}
		}
	}

}
