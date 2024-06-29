import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] bucket = new int[N + 1];
		for (int k = 0; k < M; k++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int ballNum = sc.nextInt();
			for (int l = i; l <= j; l++) {
				bucket[l] = ballNum;
			}
		}

		for (int i = 1; i <= N; i++) {
			System.out.print(bucket[i] + " ");
		}
		sc.close();
	}

}
