package Solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다리_놓기 {
	
	static int[][] dp_arr = new int[30][30];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		int answer[] = new int[T];
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			answer[i] = DP(M, N);
		}
		
		for(int i = 0; i<T; i++)
			System.out.println(answer[i]);
	}
	
	static int DP(int n, int r) {
		if(dp_arr[n][r] > 0) {
			return dp_arr[n][r];
		}
		
		if(n == r || r == 0)
			return dp_arr[n][r] = 1;
		
		return dp_arr[n][r] = DP(n-1, r-1) + DP(n-1, r);
	}
}
