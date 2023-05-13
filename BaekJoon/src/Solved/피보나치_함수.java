package Solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치_함수 {
	static int cnt0;
	static int cnt1;
	static int fibo[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int arr[] = new int[T];
		for(int i=0; i<T; i++)
			arr[i] = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			fibo = new int[arr[i] + 1];
			fibo[0] = 0;
			fibo[1] = 1;
			fibonacci(arr[i]);
			System.out.println(cnt0 + " " + cnt1);
			System.out.println("fibo : " + fibonacci1(arr[i]));
			cnt0 = 0;
			cnt1 = 0;
		}
	}
	
	static void fibonacci(int N) {
		if(N == 0) {
			cnt0++;
			return;
		}
		else if(N == 1) {
			cnt1++;
			return;
		}
		else {
			fibonacci(N-1);
			fibonacci(N-2);
		}
	}
	
	static int fibonacci1(int N) {
		if(N==0)
			return fibo[0];
		if(fibo[N] == 0) {
			fibo[N] = fibonacci1(N-1) + fibonacci1(N-2);  
		}
		return fibo[N];
	}
}
