import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int Q = Integer.parseInt(br.readLine());
		while (Q-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			binarySearch(a, d, x);
		}

		System.out.println(sb);
		br.close();
	}

	private static void binarySearch(int a, int d, int x) {
		int n = 1;
		while (a * n + ((n * (n - 1) * d) / 2) < x) {
			n++;
		}
		sb.append(n + " " + (x - (a * (n - 1) + ((n - 1) * (n - 2) * d) / 2)) + "\n");
	}

}