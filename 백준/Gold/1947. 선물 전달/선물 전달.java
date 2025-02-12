import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		if (N <= 1) {
			System.out.println(0);
			return;
		}

		long[] dp = new long[N + 1];
		dp[0] = 0;
		dp[1] = 0;
		dp[2] = 1;
		for (int i = 3; i <= N; i++) {
			//점화식 Dn = (n - 1)(D n-1 + D n-2)
			dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]) % 1000000000;
		}

		System.out.println(dp[N]);
		br.close();
	}

}
