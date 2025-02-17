import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();

		boolean find = false;
		int left = 1;
		int right = M * 5;
		while (left <= right) {
			int mid = (left + right) / 2;

			int count = 0;
			for (int i = 5; i <= mid; i*=5) {
				count += (mid / i);
			}

			if (count > M) {
				right = mid - 1;
			} else if (count < M) {
				left = mid + 1;
			} else {
				find = true;
				right = mid - 1;
			}
		}

		if (find) {
			System.out.println(left);
		} else {
			System.out.println(-1);
		}
	}

}
