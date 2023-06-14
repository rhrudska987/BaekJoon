package Solved;

import java.util.Scanner;

public class 부녀회장이_될테야 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		
//		for(int i=0; i<T; i++) {
//			int k = sc.nextInt();
//			int n = sc.nextInt();
//			int dp[] = new int[300];
//			for(int j=0; j<n; j++)
//				dp[j] = j+1;
//			for(int m=n+1; m<=n*k+n; m++) {
//				int doorNum = (m-1)%n;
//				int floorNum = (m-1)/n;
//				for(int p = 0; p<=doorNum; p++)
//					dp[m-1] += dp[(floorNum-1)*n+p];
//			}
//			sb.append(dp[n*k+n-1]+"\n");
//		}
		
		int dp[][] = new int[15][15];
		
		for(int i=0; i<15; i++) {
			dp[i][1] = 1;
			dp[0][i] = i;
		}
		
		for(int i=1; i<15; i++) {
			for(int j=2; j<15; j++) {
				dp[i][j] = dp[i][j-1] + dp[i-1][j];
			}
		}
		
		for(int i=0; i<T; i++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			sb.append(dp[k][n] + "\n");
		}
		
		System.out.println(sb.toString());		
	}
}
