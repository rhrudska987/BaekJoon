package Solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ���_ã�� {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int[][] path = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {  //���� ��� �Է�
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				path[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int mid=1; mid<=N; mid++) { //�÷��̵�-���� �˰����� �߰���带 ��������
			for(int node=1; node<=N; node++) {
				if(path[node][mid] == 1) {  
					//path[start][mid] == 1 && path[mid][end] == 1, then path[start][end] = 1
					for(int j = 1; j<=N; j++) {
						if(path[mid][j] == 1)
							path[node][j] = 1;
					}
				}
			}
		}
		
		for(int i=1; i<=N; i++) { //���� ��� ���
			for(int j=1; j<=N; j++) {
				System.out.print(path[i][j] + " ");
			}
			System.out.println();
		}
	}
}
