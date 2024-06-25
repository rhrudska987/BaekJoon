import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int P = Integer.parseInt(br.readLine());
		while (P-- > 0) {
			st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());

			int[] kids = new int[20];
			for (int i = 0; i < 20; i++) {
				kids[i] = Integer.parseInt(st.nextToken());
			}

			int total = 0;
			for (int i = 1; i < 20; i++) {
				for (int j = 0; j < i; j++) {
					if (kids[i] < kids[j]) {
						total++;
					} else {
						int tmp = kids[i];
						kids[i] = kids[j];
						kids[j] = tmp;
					}
				}
			}

			sb.append(T).append(" ").append(total).append("\n");
		}

		System.out.println(sb.toString());
		br.close();
	}
}
