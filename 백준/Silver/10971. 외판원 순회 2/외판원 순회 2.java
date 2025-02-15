import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] W;
	static boolean[] visited;
	static int minCost = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		W = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			visited[i] = true;
			bruteForce(0, i, i, 0);
			visited[i] = false;
		}

		System.out.println(minCost);
		br.close();
	}

	static void bruteForce(int depth, int startIdx, int beforeIdx, int cost) {
		if (depth == N - 1) {
			if (W[beforeIdx][startIdx] == 0) {
				return;
			}
			minCost = Math.min(cost + W[beforeIdx][startIdx], minCost);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i] || W[beforeIdx][i] == 0) {
				continue;
			}

			visited[i] = true;
			bruteForce(depth + 1, startIdx, i, cost + W[beforeIdx][i]);
			visited[i] = false;
		}
	}

}
