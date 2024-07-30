import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static char c[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;

		String input;
		while ((input = br.readLine()) != null) {
			int N = Integer.parseInt(input);
			c = new char[(int)Math.pow(3, N)];

			for (int i = 0; i < Math.pow(3, N); i++) {
				c[i] = '-';
			}

			cantor(0, (int)Math.pow(3, N));

			sb = new StringBuilder();
			for (int i = 0; i < Math.pow(3, N); i++) {
				sb.append(c[i]);
			}
			System.out.println(sb.toString());
		}

		br.close();
	}

	static void cantor(int l, int r) {
		if (l + 1 == r) {
			return;
		}

		int q = (r - l) / 3;
		for (int i = l + q; i < r - q; i++) {
			c[i] = ' ';
		}

		cantor(l, l + q);
		cantor(r - q, r);
	}

}
