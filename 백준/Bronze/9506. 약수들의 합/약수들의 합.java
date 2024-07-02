import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		while (true) {
			int n = sc.nextInt();

			if (n == -1) {
				break;
			}

			List<Integer> list = new ArrayList<>();
			int sum = 0;
			for (int i = 1; i <= n / 2; i++) {
				if (n % i == 0) {
					sum += i;
					list.add(i);
				}
			}

			if (sum == n) {
				sb.append(n + " = ");
				for (int i = 0; i < list.size() - 1; i++) {
					sb.append(list.get(i) + " + ");
				}
				sb.append(list.get(list.size() - 1) + "\n");
			} else {
				sb.append(n + " is NOT perfect.\n");
			}
		}

		System.out.println(sb.toString());
		sc.close();
	}
}
