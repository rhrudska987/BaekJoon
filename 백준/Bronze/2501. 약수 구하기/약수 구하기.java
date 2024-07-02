import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();
		int K = sc.nextInt();

		int ans = 0;
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (N % i == 0) {
				ans = i;
				cnt++;
			}
			if (cnt == K) {
				break;
			}
		}

		if (cnt < K) {
			System.out.println(0);
		} else {
			System.out.println(ans);
		}

		sc.close();
	}
}
