package Solved;

import java.util.Scanner;

public class 일이삼_더하기 {
	
	static int dp_arr[] = new int[12];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		dp_arr[1] = 1;
		dp_arr[2] = 2;
		dp_arr[3] = 4;
		for(int i=4; i<=11; i++)
			dp_arr[i] = dp_arr[i-1] + dp_arr[i-2] + dp_arr[i-3];
		
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			int n = sc.nextInt();
			sb.append(dp_arr[n] + "\n");
		}
		System.out.println(sb.toString());
	}
}
