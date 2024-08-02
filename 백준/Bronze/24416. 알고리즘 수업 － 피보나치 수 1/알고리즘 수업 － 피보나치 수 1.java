import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int cnt1 = 0;
	static int cnt2 = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		fib(n);
		fibonacci(n);
		System.out.println(cnt1 + " " + cnt2);
		br.close();
	}

	static int fib(int n) {
		if (n == 1 || n == 2) {
			cnt1++;
			return 1;
		}

		return fib(n - 1) + fib(n - 2);
	}

	static int fibonacci(int n) {
		int[] f = new int[n + 1];
		f[1] = 1;
		f[2] = 1;

		for (int i = 3; i <= n; i++) {
			f[i] = f[i - 1] + f[i - 2];
			cnt2++;
		}

		return f[n];
	}

}
