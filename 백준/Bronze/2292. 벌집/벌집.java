import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 1;
		int num = 1;
		int plusNum = 6;

		while (N > num) {
			num += plusNum;
			plusNum += 6;
			cnt++;
		}

		System.out.println(cnt);
		sc.close();
	}
}
