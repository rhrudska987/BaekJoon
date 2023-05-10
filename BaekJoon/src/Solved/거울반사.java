package Solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 거울반사 {
	
	static int arr[][];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		
		String W = st.nextToken();
		int N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(W.equals("L") || W.equals("R"))
			left_right(N);
		else
			up_down(N);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N-1; j++) {
				if(arr[i][j] == 0)
					System.out.print("? ");
				else
					System.out.print(arr[i][j] + " ");
			}
			if(arr[i][N-1] == 0)
				System.out.println("?");
			else
				System.out.println(arr[i][N-1]);
		}
		
	}
	
	public static void left_right(int N) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N/2; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][N-1-j];
				arr[i][N-1-j] = temp;
				if(arr[i][j] == 1 || arr[i][j] == 2 || arr[i][j] == 5 || arr[i][j] == 8)
					arr[i][j] = changeNumber(arr[i][j]);
				else
					arr[i][j] = 0;
				if(arr[i][N-1-j] == 1 || arr[i][N-1-j] == 2 || arr[i][N-1-j] == 5 || arr[i][N-1-j] == 8)
					arr[i][N-1-j] = changeNumber(arr[i][N-1-j]);
				else
					arr[i][N-1-j] = 0;
			}
		}
		if(N%2 == 1) {
			for(int i=0; i<N; i++) {
				if(arr[i][N/2] == 1 || arr[i][N/2] == 2 || arr[i][N/2] == 5 || arr[i][N/2] == 8)
					arr[i][N/2] = changeNumber(arr[i][N/2]);
				else
					arr[i][N/2] = 0;
			}
		}
	}
	
	public static void up_down(int N) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N/2; j++) {
				int temp = arr[j][i];
				arr[j][i] = arr[N-1-j][i];
				arr[N-1-j][i] = temp;
				if(arr[j][i] == 1 || arr[j][i] == 2 || arr[j][i] == 5 || arr[j][i] == 8)
					arr[j][i] = changeNumber(arr[j][i]);
				else
					arr[j][i] = 0;
				if(arr[N-1-j][i] == 1 || arr[N-1-j][i] == 2 || arr[N-1-j][i] == 5 || arr[N-1-j][i] == 8)
					arr[N-1-j][i] = changeNumber(arr[N-1-j][i]);
				else
					arr[N-1-j][i] = 0;
			}
		}
		if(N%2 == 1) {
			for(int i=0; i<N; i++) {
				if(arr[N/2][i] == 1 || arr[N/2][i] == 2 || arr[N/2][i] == 5 || arr[N/2][i] == 8)
					arr[N/2][i] = changeNumber(arr[N/2][i]);
				else
					arr[N/2][i] = 0;
			}
		}
	}
	
	public static int changeNumber(int num) {
		switch(num) {
			case 2:
				num = 5;
				return num;
			case 5:
				num = 2;
				return num;
			default :
				return num;
		}
	}
}
