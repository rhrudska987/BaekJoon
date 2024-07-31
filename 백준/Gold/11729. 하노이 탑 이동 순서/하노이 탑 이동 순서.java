import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static int cnt = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		hanoi(N, 1, 2, 3);
		
		sb.insert(0, "\n");
		sb.insert(0, cnt);
		System.out.println(sb.toString());
		br.close();
	}

	static void hanoi(int n, int l, int m, int r) {
		if (n == 0) {
			return;
		}
		cnt++;
		hanoi(n - 1 ,l, r, m);
		sb.append(l).append(" ").append(r).append("\n");
		hanoi(n - 1, m, l, r);
	}

}
