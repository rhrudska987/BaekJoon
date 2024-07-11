import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();
		while (T-- > 0) {
			long n = sc.nextLong();
			if (n == 0 || n == 1) {
				sb.append(2).append("\n");
				continue;
			}

			while (true) {
				boolean isPrime = true;
				for (long j = 2; j <= Math.sqrt(n); j++) {
					if (n % j == 0) {
						isPrime = false;
						break;
					}
				}

				if (isPrime) {
					sb.append(n).append("\n");
					break;
				}
				n++;
			}
		}

		System.out.println(sb.toString());
		sc.close();
	}

}
