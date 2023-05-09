package Solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class �κм�����_�� {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int S[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) 
			S[i] = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N-1; i++) {  //���� ���� (��������)
			for(int j=i+1; j<N; j++) {
				if(S[i] > S[j]) {
					int tmp = S[i];
					S[i] = S[j];
					S[j] = tmp;
				}
			}
		}
		
		//ù ��° ������ i-1��° ������ ��� ���� ��+1 ������ ���� i��° ���� ���� ��� �̾ ���� �� ����
		int answer = 0;
		for(int i=0; i<N; i++) {
			if(answer + 1 < S[i])
				break;
			answer += S[i];
		}
		System.out.println(answer + 1);
	}
}
