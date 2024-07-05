import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N + 1];
		dp[1] = 0;

		//dp 1에서 N을 만드는 데, 필요한 연산 횟수의 최솟값 (Bottom - Top)
		//N  - 1 2 3 4 5 6
		//DP - 0 1 1 2 3 ?

		for (int i = 2; i <= N; i++) {
			//1을 뺀다. 
			//dp[5] + 1 -> dp[6]
			dp[i] = dp[i - 1] + 1;

			//N이 2로 나누어 떨어지면, 2로 나눈다.
			//dp[3] + 1 -> dp[6]
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			}

			//N이 3으로 나누어 떨어지면, 3으로 나눈다.
			//dp[2] + 1 -> dp[6]
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			}
		}

		System.out.println(dp[N]);
		br.close();
	}
}
