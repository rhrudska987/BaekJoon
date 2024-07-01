import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] c = sc.next().toCharArray();
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += c[i] - '0';
		}
		System.out.println(sum);
		sc.close();
	}
}
