package Solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ���� {
	static int[] g;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		
		g = new int[G+1];
		for(int i=1; i<=G; i++) {
			g[i] = i;
		}
		
		int answer = 0;
		
		for(int i=0; i<P; i++) {
			int gi = Integer.parseInt(br.readLine());
			int emptyGate = find(gi);
			if(emptyGate == 0)
				break;
			answer++;
			union(emptyGate, emptyGate-1);	
		}
		
		for(int i=0; i<G+1; i++) {
			System.out.println(i + " : " + g[i]);
		}
		System.out.println(answer);
	}
	
	private static int find(int gi) {
		if(gi == g[gi])
			return gi;
		else {
			return g[gi] = find(g[gi]);
		}
	}
	
	private static void union(int x, int y) {
		int nx = find(x);
		int ny = find(y);
		if(nx != ny) {
			g[nx] = ny;
		}
	}

}
