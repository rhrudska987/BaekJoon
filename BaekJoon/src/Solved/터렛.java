package Solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ≈Õ∑ø {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		int answer[] = new int[T];
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int arr[] = new int[6];
			for(int j=0; j<6; j++)
				arr[j] = Integer.parseInt(st.nextToken());
			int x1 = arr[0];
			int y1 = arr[1];
			int r1 = arr[2];
			int x2 = arr[3];
			int y2 = arr[4];
			int r2 = arr[5];
			if(x1 == x2 && y1 == y2 && r1 == r2)
				answer[i] = -1;
			else if((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2) > (r1+r2)*(r1+r2))
				answer[i] = 0;
			else if((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2) < (r1-r2)*(r1-r2))
				answer[i] = 0;
			else if((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2) == (r1-r2)*(r1-r2))
				answer[i] = 1;
			else if((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2) == (r1+r2)*(r1+r2))
				answer[i] = 1;
			else
				answer[i] = 2;
			
		}
		for(int i=0; i<T; i++) {
			System.out.println(answer[i]);
		}
	}
}
