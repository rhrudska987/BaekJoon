import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] bucket = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			bucket[i] = i;
		}

		for (int k = 0; k < M; k++) {
			int i = sc.nextInt();
			int j = sc.nextInt();

			while (i < j) {
				int tmp = bucket[i];
				bucket[i] = bucket[j];
				bucket[j] = tmp;
				i++;
				j--;
			}
		}

		for (int i = 1; i <= N; i++) {
			System.out.print(bucket[i] + " ");
		}

		sc.close();
	}

}
