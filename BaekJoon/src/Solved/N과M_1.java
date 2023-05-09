package Solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N°úM_1 {
	static int arr[];
	static int visit[];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		visit = new int[N+1];
		
		DFS(N, M, 0);
	}
	
	public static void DFS(int N, int M, int point) {
		if(point == M) {
			for(int i=0; i<M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(visit[i] == 0) {
				visit[i] = 1;
				arr[point] = i;
				DFS(N, M, point+1);
				visit[i] = 0;
			}
		}
	}
}
