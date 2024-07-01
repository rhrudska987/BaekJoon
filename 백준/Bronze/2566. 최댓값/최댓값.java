import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] A = new int[10][10];

		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				A[i][j] = sc.nextInt();
			}
		}

		int max = 0;
		int r = 1;
		int c = 1;
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				if (A[i][j] > max) {
					max = A[i][j];
					r = j;
					c = i;
				}
			}
		}

		System.out.println(max);
		System.out.println(c + " " + r);

		sc.close();
	}
}
