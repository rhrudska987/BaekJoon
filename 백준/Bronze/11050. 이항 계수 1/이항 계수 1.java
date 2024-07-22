import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int ans = 1;
		for (int i = N; i > N - K; i--) {
			ans *= i;
		}
		for (int i = K; i > 0; i--) {
			ans /= i;
		}
		System.out.println(ans);
		br.close();
	}
}
