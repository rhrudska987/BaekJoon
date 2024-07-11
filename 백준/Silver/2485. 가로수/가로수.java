import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int min = Math.abs(arr[0] - arr[1]);
		for (int i = 1; i < N - 1; i++) {
			min = Math.min(min, Math.abs(arr[i] - arr[i + 1]));
		}

		int ans = Integer.MAX_VALUE;
		for (int i = min; i > 0; i--) {
			int cnt = 0;
			int idx = 0;
			int now = arr[idx++];
			boolean check = true;
			while (idx < N) {
				now += i;
				if (now > arr[idx]) {
					check = false;
					break;
				} else if (now == arr[idx]) {
					idx++;
				} else {
					cnt++;
				}
			}

			if (now != arr[N - 1]) {
				check = false;
			}

			if (check) {
				System.out.println(cnt);
				break;
			}
		}

		sc.close();
	}

}
