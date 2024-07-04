import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();

		int numerator = B * C + A * D;
		int denominator = B * D;

		for (int i = 2; i <= denominator; i++) {
			if (numerator % i == 0 && denominator % i == 0) {
				numerator /= i;
				denominator /= i;
				i--;
			}
		}

		System.out.println(numerator + " " + denominator);
		sc.close();
	}

}
