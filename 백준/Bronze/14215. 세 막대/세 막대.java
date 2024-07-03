import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int maxStick = Math.max(a, b);
		maxStick = Math.max(maxStick, c);
		if (maxStick == a) {
			if (a >= b + c) {
				System.out.println(b + c + b + c - 1);
			} else {
				System.out.println(a + b + c);
			}
		} else if (maxStick == b) {
			if (b >= a + c) {
				System.out.println(a + c + a + c - 1);
			} else {
				System.out.println(a + b + c);
			}
		} else {
			if (c >= b + a) {
				System.out.println(b + a + b + a - 1);
			} else {
				System.out.println(a + b + c);
			}
		}

		br.close();
	}
}
