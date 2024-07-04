import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextInt();
		long B = sc.nextInt();

		long idx = 1;
		if (A > B) {
			while (A * idx % B != 0) {
				idx++;
			}
			System.out.println(A * idx);
		} else {
			while (B * idx % A != 0) {
				idx++;
			}
			System.out.println(B * idx);
		}

		sc.close();
	}

}
