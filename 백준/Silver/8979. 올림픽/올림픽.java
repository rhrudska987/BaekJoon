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

		int[][] nation = new int[N][4];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			nation[i][0] = Integer.parseInt(st.nextToken());
			nation[i][1] = Integer.parseInt(st.nextToken());
			nation[i][2] = Integer.parseInt(st.nextToken());
			nation[i][3] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(nation, (o1, o2) -> {
			if (o1[1] == o2[1]) {
				if (o1[2] == o2[2]) {
					return o2[3] - o1[3];
				}
				return o2[2] - o1[2];
			}
			return o2[1] - o1[1];
		});

		int ans = 0;
		for (int i = 0; i < N; i++) {
			if (nation[i][0] == K) {
				ans = i + 1;
				for (int j = i - 1; j >= 0; j--) {
					if (nation[i][1] == nation[j][1] && nation[i][2] == nation[j][2] && nation[i][3] == nation[j][3]) {
						ans--;
					}
				}
			}
		}

		System.out.println(ans);
		br.close();
	}
}
