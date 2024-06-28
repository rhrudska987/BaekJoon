import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	static int ans;
	static int[] col;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		ans = 0;
		col = new int[N];
		
		find(0);
		
		System.out.println(ans);
		br.close();
	}
	
	static void find(int row) {
		if (row == N) {
			ans++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			col[row] = i;
			if (isPossible(row)) {
				find(row + 1);
			}
		}
	}
	
	static boolean isPossible(int row) {
		for (int i = 0; i < row; i++) {
			if (col[row] == col[i] || Math.abs(col[row] - col[i]) == row - i) {
				return false;
			}
		}
		
		return true;
	}
		
}
