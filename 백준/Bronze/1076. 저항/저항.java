import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] register = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};

		long sum = 0;
		for (int i = 0; i < 3; i++) {
			String r = sc.nextLine();
			for (int j = 0; j < 10; j++) {
				if (r.equals(register[j])) {
					if (i == 2) {
						sum *= Math.pow(10, j);
					} else {
						sum = sum * 10 + j;
					}
				}
			}
		}
		System.out.println(sum);
		sc.close();
	}

}
