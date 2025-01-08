import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] road = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				road[i][j] = 10000;

				if (i == j) {
					road[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			road[A][B] = road[B][A] = 2;
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					road[i][j] = Math.min(road[i][j], road[i][k] + road[k][j]);
				}
			}
		}
		
		// for (int i = 1; i <= N; i++) {
		// 	for (int j = 1; j <= N; j++) {
		// 		System.out.print(road[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }

		int[] answer = new int[2];
		int minSum = Integer.MAX_VALUE;
		int[] times = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				times[j] = road[i][j];
			}

			for (int j = i + 1; j <= N; j++) {
				int sum = 0;
				for (int k = 1; k <= N; k++) {
					sum += Math.min(times[k], road[j][k]);
				}

				if (sum < minSum) {
					minSum = sum;
					answer[0] = i;
					answer[1] = j;
				}
			}
		}
		System.out.println(answer[0] + " " + answer[1] + " " + minSum);
		br.close();



	}

}
