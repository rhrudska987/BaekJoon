import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static String[][] board;
	static String[][] chess1 = {
		{"W", "B", "W", "B", "W", "B", "W", "B"},
		{"B", "W", "B", "W", "B", "W", "B", "W"},
		{"W", "B", "W", "B", "W", "B", "W", "B"},
		{"B", "W", "B", "W", "B", "W", "B", "W"},
		{"W", "B", "W", "B", "W", "B", "W", "B"},
		{"B", "W", "B", "W", "B", "W", "B", "W"},
		{"W", "B", "W", "B", "W", "B", "W", "B"},
		{"B", "W", "B", "W", "B", "W", "B", "W"},
	};
	static String[][] chess2 = {
		{"B", "W", "B", "W", "B", "W", "B", "W"},
		{"W", "B", "W", "B", "W", "B", "W", "B"},
		{"B", "W", "B", "W", "B", "W", "B", "W"},
		{"W", "B", "W", "B", "W", "B", "W", "B"},
		{"B", "W", "B", "W", "B", "W", "B", "W"},
		{"W", "B", "W", "B", "W", "B", "W", "B"},
		{"B", "W", "B", "W", "B", "W", "B", "W"},
		{"W", "B", "W", "B", "W", "B", "W", "B"},
	};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		board = new String[N][M];
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().split("");
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				int cnt1 = 0;
				int cnt2 = 0;
				for (int k = 0; k < 8; k++) {
					for (int l = 0; l < 8; l++) {
						if (!board[i + k][j + l].equals(chess1[k][l])) {
							cnt1++;
						}
					}
				}

				for (int k = 0; k < 8; k++) {
					for (int l = 0; l < 8; l++) {
						if (!board[i + k][j + l].equals(chess2[k][l])) {
							cnt2++;
						}
					}
				}

				cnt1 = Math.min(cnt1, cnt2);
				min = Math.min(cnt1, min);
			}
		}

		System.out.println(min);
		br.close();
	}

}
