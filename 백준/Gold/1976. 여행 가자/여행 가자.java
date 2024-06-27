import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int[][] map = new int[N + 1][N + 1];
		int[] travelCity = new int[M];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					map[i][j] = 100000;
				}
				if (i == j) {
					map[i][j] = 1;
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			travelCity[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}

		boolean isPossible = true;
		for (int i = 0; i < M - 1; i++) {
			int start = travelCity[i];
			int end = travelCity[i + 1];
			
			if (map[start][end] >= 100000) {
				isPossible = false;
			}
		}

		if (isPossible) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

		br.close();
	}

}
