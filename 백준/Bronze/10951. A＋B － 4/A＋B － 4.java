import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (sc.hasNext()) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			sb.append(A + B);
			sb.append("\n");
		}

		System.out.println(sb.toString());
		sc.close();
	}
}
