import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] nation = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			nation[i][0] = Integer.parseInt(st.nextToken());

			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());
			nation[i][1] = 3 * gold + 2 * silver + 1 * bronze;
		}

		Arrays.sort(nation, (o1, o2) -> {
			return o2[1] - o1[1];
		});

		int ans = 0;
		for (int i = 0; i < N; i++) {
			if (nation[i][0] == K) {
				ans = i + 1;
				for (int j = i - 1; j >= 0; j--) {
					if (nation[i][1] == nation[j][1]) {
						ans--;
					}
				}
			}
		}

		System.out.println(ans);
		br.close();
	}
}
