import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < N - 1 - i; j++) {
				sb.append(" ");
			}
			for (int j = 0; j < 2 * i + 1; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}

		for (int j = 0; j < 2 * N - 1; j++) {
			sb.append("*");
		}
		sb.append("\n");

		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < i + 1; j++) {
				sb.append(" ");
			}
			for (int j = 0; j < 2 * N - (2 * i + 3); j++) {
				sb.append("*");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
		br.close();
	}
}
