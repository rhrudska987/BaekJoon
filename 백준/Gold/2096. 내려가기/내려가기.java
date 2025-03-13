import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] scores = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				scores[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dp = new int[2][3];
		dp[0][0] = scores[0][0];
		dp[0][1] = scores[0][1];
		dp[0][2] = scores[0][2];

		for (int i = 1; i < N; i++) {
			dp[1][0] = scores[i][0] + Math.max(dp[0][0], dp[0][1]);
			dp[1][1] = scores[i][1] + Math.max(Math.max(dp[0][0], dp[0][1]), dp[0][2]);
			dp[1][2] = scores[i][2] + Math.max(dp[0][1], dp[0][2]);

			dp[0][0] = dp[1][0];
			dp[0][1] = dp[1][1];
			dp[0][2] = dp[1][2];
		}
		int maxScore = Math.max(dp[0][0], Math.max(dp[0][1], dp[0][2]));

		dp[0][0] = scores[0][0];
		dp[0][1] = scores[0][1];
		dp[0][2] = scores[0][2];
		for (int i = 1; i < N; i++) {
			dp[1][0] = scores[i][0] + Math.min(dp[0][0], dp[0][1]);
			dp[1][1] = scores[i][1] + Math.min(Math.min(dp[0][0], dp[0][1]), dp[0][2]);
			dp[1][2] = scores[i][2] + Math.min(dp[0][1], dp[0][2]);

			dp[0][0] = dp[1][0];
			dp[0][1] = dp[1][1];
			dp[0][2] = dp[1][2];
		}
		int minScore = Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));

		System.out.println(maxScore + " " + minScore);
		br.close();
	}

}
