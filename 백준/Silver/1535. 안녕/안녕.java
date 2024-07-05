import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] loseStrength = new int[N];
		int[] gainHappiness = new int[N];

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			loseStrength[i] = Integer.parseInt(st1.nextToken());
			gainHappiness[i] = Integer.parseInt(st2.nextToken());
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
