package Solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class °ö¼À {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		if(B == 1) {
			if(A >= C)
				System.out.println(A % C);
			else
				System.out.println(A);
		}
		else {
			if(A*A >= C)
				System.out.println(A*A % C);
			else
				System.out.println(A*A);
		}
		
	}

}
