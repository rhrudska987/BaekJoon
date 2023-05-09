package Solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ����_���� {
	
	static int stack[] = new int[100000];
	static int point = -1;
	
	public static void push(int num) {
		stack[++point] = num;	
	}
	
	public static int pop() {
		if(point < 0) {
			return -1;
		}
		return stack[point--];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int current_num = 1;
		int idx = 0;
		int n_arr[] = new int[n];
		for(int i=0; i<n; i++) {
			n_arr[i] = Integer.parseInt(br.readLine());
		}
		
		while(current_num <= n) {
			if(current_num == n && point == -1) {  //���ÿ� �� ���ڰ� n�� ���� ������ �� �̻� �� ���ڰ� ���ٸ�
				sb.append("+\n");
				sb.append("-");
				System.out.println(sb);
				br.close();
				System.exit(0);
			}
			if(current_num == n_arr[idx]) {   //push�� pop�� �� �� �ؾ��ϴ°��
				sb.append("+\n");
				sb.append("-\n");
				push(current_num);
				pop();
				current_num++;
				idx++;	
			}
			else if(current_num > n_arr[idx]) {  
				sb.append("-\n");
				int popNum = pop();
				if(popNum != n_arr[idx]) {
					System.out.println("NO");
					br.close();
					System.exit(0);
				}
				idx++;
			}
			else {
				sb.append("+\n");
				push(current_num);
				current_num++;
			}
		}
		
		while(idx < n) { //n_arr�� ���� ���ڵ��� ���������̾�� �Ѵ�
			if(idx == n-1) {
				sb.append("-");
				break;
			}
			if(n_arr[idx] < n_arr[idx+1]) {
				System.out.println("NO");
				br.close();
				System.exit(0);
			}
			else {
				sb.append("-\n");
				idx++;
			}
		}
		System.out.println(sb);
		br.close();
	}
}
