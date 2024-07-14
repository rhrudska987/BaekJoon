import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();

		boolean[] arr = new boolean[1000001];
		for (int i = 2; i <= 1000000; i++) {
			boolean isPrime = true;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}

			if (isPrime) {
				arr[i] = true;
			}
		}

		while (T-- > 0) {
			int N = sc.nextInt();

			int cnt = 0;
			for (int i = 2; i <= N / 2; i++) {
				if (arr[i] && arr[N - i]) {
					cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}

		System.out.println(sb.toString());
		sc.close();
	}

}
