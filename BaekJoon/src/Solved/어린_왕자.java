package Solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ¾î¸°_¿ÕÀÚ {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		int[] cntInOut = new int[T];
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(br.readLine());
			for(int j=0; j<N; j++) {
				st = new StringTokenizer(br.readLine());
				int cx = Integer.parseInt(st.nextToken());
				int cy = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				int point1 = (x1-cx)*(x1-cx) + (y1-cy)*(y1-cy) - r*r;
				int point2 = (x2-cx)*(x2-cx) + (y2-cy)*(y2-cy) - r*r;
				if(point1 < 0 && point2 > 0 || point1 > 0 && point2 < 0) {
					cntInOut[i]++;
				}
			}
		}
		
		for(int i=0; i<T; i++) {
			System.out.println(cntInOut[i]);
		}
	}
}
