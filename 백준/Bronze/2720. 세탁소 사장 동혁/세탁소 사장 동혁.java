import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		while (T-- > 0) {
			int money = sc.nextInt();
			int[] money_arr = new int[4];

			while (money > 24) {
				money -= 25;
				money_arr[0]++;
			}

			while (money > 9) {
				money -= 10;
				money_arr[1]++;
			}

			while (money > 4) {
				money -= 5;
				money_arr[2]++;
			}

			while (money > 0) {
				money -= 1;
				money_arr[3]++;
			}

			sb.append(money_arr[0] + " ")
				.append(money_arr[1] + " ")
				.append(money_arr[2] + " ")
				.append(money_arr[3] + " ")
				.append("\n");
		}

		System.out.println(sb.toString());
		sc.close();
	}
}
