import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int V = sc.nextInt();

		int days = 0;
		days = (V - B) / (A - B);
		if ((V - B) % (A - B) != 0) {
			days++;
		}
		System.out.println(days);
		sc.close();
	}
}