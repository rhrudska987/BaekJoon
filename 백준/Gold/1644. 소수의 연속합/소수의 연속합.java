import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		List<Integer> list = new ArrayList<>();
		for (int i = 2; i <= N; i++) {
			boolean isPrime = true;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}

			if (isPrime) {
				list.add(i);
			}
		}

		list.add(4000001);

		int answer = 0;
		int left = 0;
		int right = 0;
		int sum = list.get(left);
		while (right < list.size() - 1 && left <= right) {
			if (sum == N) {
				answer++;
				sum += list.get(++right);
			}

			if (sum > N) {
				sum -= list.get(left++);
			} else {
				sum += list.get(++right);
			}
		}

		System.out.println(answer);
        sc.close();
	}

}
