package Solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ������_�迭��_�� {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int NM_arr[][] = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				NM_arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		int K_arr[][] = new int[K][4];
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 4; j++) {
				K_arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int l = 0; l < K; l++) {
			int i = K_arr[l][0];
			int j = K_arr[l][1];
			int x = K_arr[l][2];
			int y = K_arr[l][3];
			int sum = 0;
			int tmp = j;
			
			for(; i <= x; i++) {
				for(; j <= y; j++)
					sum += NM_arr[i-1][j-1];
				j = tmp;
			}
			sb.append(String.valueOf(sum) + "\n");
		}
		System.out.println(sb.toString());
		br.close();

		
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		
//		StringTokenizer st = null;
//		
//		st = new StringTokenizer(br.readLine());
//		
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//		
//		int NM_arr[][] = new int[N][M];
//		for(int i = 0; i < N; i++) {
//			st = new StringTokenizer(br.readLine());
//			for(int j = 0; j < M; j++) {
//				NM_arr[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//		
//		int K = Integer.parseInt(br.readLine());
//		int K_arr[][] = new int[K][4];
//		
//		for(int i = 0; i < K; i++) {
//			st = new StringTokenizer(br.readLine());
//			for(int j = 0; j < 4; j++) {
//				K_arr[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//		
//		for(int l = 0; l < K; l++) {
//			int i = K_arr[l][0];
//			int j = K_arr[l][1];
//			int x = K_arr[l][2];
//			int y = K_arr[l][3];
//			int sum = 0;
//			int tmp = j;
//			
//			for(; i <= x; i++) {
//				for(; j <= y; j++)
//					sum += NM_arr[i-1][j-1];
//				j = tmp;
//			}
//			bw.write(String.valueOf(sum) + "\n");
//		}
//		bw.flush();
//		bw.close();
//		br.close();
		
		
//		int N = sc.nextInt();
//		int M = sc.nextInt();
//		int NM_arr[][] = new int[N][M];
//		
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < M; j++) {
//				NM_arr[i][j] = sc.nextInt();
//			}
//		}
//		
//		int K = sc.nextInt();
//		int K_arr[][] = new int[K][4];
//		
//		for(int i = 0; i < K; i++) {
//			for(int j = 0; j < 4; j++) {
//				K_arr[i][j] = sc.nextInt();
//			}
//		}
//		
//		for(int l = 0; l < K; l++) {
//			int i = K_arr[l][0];
//			int j = K_arr[l][1];
//			int x = K_arr[l][2];
//			int y = K_arr[l][3];
//			int sum = 0;
//			int tmp = j;
//			
//			for(; i <= x; i++) {
//				for(; j <= y; j++)
//					sum += NM_arr[i-1][j-1];
//				j = tmp;
//			}
//			System.out.println(sum);
//		}
	}
}
