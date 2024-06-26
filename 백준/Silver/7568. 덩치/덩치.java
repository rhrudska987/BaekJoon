import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int[][] person = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			person[i][0] = Integer.parseInt(st.nextToken());
			person[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			int ans = 1;
			for (int j = 0; j < N; j++) {
				if (person[i][0] < person[j][0] && person[i][1] < person[j][1]) {
					ans++;
				}
			}
			System.out.print(ans + " ");
		}

		br.close();
	}
}
