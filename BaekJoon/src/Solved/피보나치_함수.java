package Solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치_함수 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int arr[] = new int[T];
		int max = 0;
		for(int i=0; i<T; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i] > max)
				max = arr[i];
		}
		
		int[] cnt0 = new int[max+1];
		int[] cnt1 = new int[max+1];
		
		for(int i=0; i<=max; i++) {
			if(i == 0) {
				cnt0[0] = 1;
				cnt1[0] = 0;
			}
			else if(i == 1) {
				cnt0[1] = 0;
				cnt1[1] = 1;
			}
			else {
				cnt0[i] = cnt0[i-1] + cnt0[i-2];
				cnt1[i] = cnt1[i-1] + cnt1[i-2];
			}
		}
		
		for(int i=0; i<T; i++) {
			System.out.println(cnt0[arr[i]] + " " + cnt1[arr[i]]);
		}	
	}
}
