import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
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
		
		int cnt = 1;
		int aa = 0;
		int n_arr[] = new int[n];
		for(int i=0; i<n; i++) {
			n_arr[i] = Integer.parseInt(br.readLine());
		}
		
		while(cnt <= n) {
			if(cnt == n && point == -1) {
				sb.append("+\n");
				sb.append("-");
				System.out.println(sb);
				br.close();
				System.exit(0);
			}
			if(cnt == n_arr[aa]) {
				sb.append("+\n");
				sb.append("-\n");
				push(cnt);
				pop();
				cnt++;
				aa++;	
			}
			else if(cnt > n_arr[aa]) {
				sb.append("-\n");
				int popNum = pop();
				if(popNum != n_arr[aa]) {
					System.out.println("NO");
					br.close();
					System.exit(0);
				}
				aa++;
			}
			else {
				sb.append("+\n");
				push(cnt);
				cnt++;
			}
		}
		
		while(aa < n) {
			if(aa == n-1) {
				sb.append("-");
				break;
			}
			if(n_arr[aa] < n_arr[aa+1]) {
				System.out.println("NO");
				br.close();
				System.exit(0);
			}
			else {
				sb.append("-\n");
				aa++;
			}
		}
		System.out.println(sb);
		br.close();
	}
}
