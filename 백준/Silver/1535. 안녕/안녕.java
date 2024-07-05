import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int[] loseStrength = new int[N];
		int[] gainHappiness = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			loseStrength[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			gainHappiness[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[100];
		for (int i = 0; i < N; i++) {
			for (int j = 99; j > 0; j--) {
				if (loseStrength[i] <= j) {
					dp[j] = Math.max(dp[j], gainHappiness[i] + dp[j - loseStrength[i]]);
				}
			}
		}

		System.out.println(dp[99]);
		br.close();
	}

}
