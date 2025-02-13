import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static long dp[] = new long[21];

	public static void main(String[] args) throws IOException {
		initDp();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			sb.append(dp[N]).append("\n");
		}

		System.out.println(sb);
		br.close();
	}

	private static void initDp() {
		dp[0] = 0;
		dp[1] = 0;
		dp[2] = 1;

		for (int i = 3; i <= 20; i++) {
			dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]);
		}
	}

}
