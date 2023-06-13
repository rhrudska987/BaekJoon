package Solved;

import java.util.Scanner;

public class º≥≈¡_πË¥ﬁ {
	
	static int dp_arr[];
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp_arr = new int[5000];
		dp_arr[3] = 1;
		dp_arr[5] = 1;
		
		for(int i=6; i<=N; i++) {
			if(dp_arr[i-3] == 0 && dp_arr[i-5] == 0)
				continue;
			else if(dp_arr[i-3] == 0 && dp_arr[i-5] != 0)
				dp_arr[i] = dp_arr[i-5] + 1;
			else if(dp_arr[i-3] != 0 && dp_arr[i-5] == 0)
				dp_arr[i] = dp_arr[i-3] + 1;
			else {
				if(dp_arr[i-3] <= dp_arr[i-5])
					dp_arr[i] = dp_arr[i-3]+1;
				else
					dp_arr[i] = dp_arr[i-5]+1;
			}
		}
		
//		DP(3);
//		DP(5);
		if(dp_arr[N] == 0)
			System.out.println(-1);
		else
			System.out.println(dp_arr[N]);
	}
	
//	static void DP(int num) {
//		if(num > N)
//			return;
//		if(num+3 <= N && dp_arr[num]+1 < dp_arr[num+3] || num+3 <= N && dp_arr[num+3] == 0)
//			dp_arr[num+3] = dp_arr[num]+1;
//		if(num+5 <= N && dp_arr[num]+1 < dp_arr[num+5] || num+5 <= N && dp_arr[num+5] == 0)
//			dp_arr[num+5] = dp_arr[num]+1;
//		DP(num+3);
//		DP(num+5);
//	}
	
}
