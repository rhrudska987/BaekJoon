import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(fibo(Integer.parseInt(br.readLine())));
		br.close();
	}
	
	static long fibo(int n) {
		if (n == 0) {
			return 1;
		}
		return n * fibo(n - 1);
	}
}
