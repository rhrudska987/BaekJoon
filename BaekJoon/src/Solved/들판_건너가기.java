package Solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 들판_건너가기 {
	static int N;
	static int[] value;
	static ArrayList<Integer> flowers = new ArrayList<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		value = new int[N];
		for(int i = 0; i<N; i++)
			value[i] = Integer.parseInt(st.nextToken());
		
		if(N == 2) {
			System.out.println((value[0] - value[1])*(value[0] - value[1]));
			return;
		}
		
		boolean toSmall = false;
		boolean toBig = false;
		
		if(value[0] <= value[1]) {
			flowers.add(value[0]);
			toSmall = true;
		}
		else {
			flowers.add(value[0]);
			toBig = true;
		}
		
		for(int i=2; i<N; i++) {
			if(i == N-1)
				flowers.add(value[i]);
			if(value[i] - value[i-1] > 0) {
				if(toBig) {
					flowers.add(value[i-1]);
				}
				toSmall = true;
				toBig = false;
			}
			else {
				if(toSmall) {
					flowers.add(value[i-1]);
				}
				toSmall = false;
				toBig = true;
			}
		}
		
		long sum = 0;
		
		for(int i=0; i<flowers.size() - 1; i++) 
			sum += (long)(flowers.get(i) - flowers.get(i+1))*(long)(flowers.get(i) - flowers.get(i+1));	
			
		System.out.println(sum);
		
	}	
}
