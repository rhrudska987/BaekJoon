import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int start, end;
	static long[][] dp;

	public static void main(String[] args) throws IOException {
		readInput();
		calculateMinPaths();
		printAnswer();
	}

	private static void readInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int H = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		start = Math.min(H, N);
		end = Math.max(H, N);
		dp = new long[end + 1][end + 1];

		br.close();
	}

	private static void calculateMinPaths() {
		for (int i = start; i <= end; i++) {
			for (int j = start; j <= end; j++) {
				if (j > i) {
					continue;
				}

				if (i == start && j == start) {
					dp[i][j] = 1; //시작점은 1
				} else if (i - 1 < start) {
					dp[i][j] = dp[i][j - 1];
				} else if (j - 1 < start) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = dp[i][j-1] + dp[i - 1][j];
				}
			}
		}
	}

	private static void printAnswer() {
		System.out.println(dp[end][end]);
	}

}
