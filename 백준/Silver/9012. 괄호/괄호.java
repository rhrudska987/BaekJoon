import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		sc.nextLine();

		while (T-- > 0) {
			String[] s = sc.nextLine().split("");
			int cnt = 0;
			boolean isVPS = true;
			for (int i = 0; i < s.length; i++) {
				if (s[i].equals("(")) {
					cnt++;
				} else {
					if (cnt != 0) {
						cnt--;
					} else {
						isVPS = false;
						break;
					}
				}
			}

			if (cnt != 0) {
				isVPS = false;
			}

			if (isVPS) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		}

		System.out.println(sb.toString());
		sc.close();
	}

}
