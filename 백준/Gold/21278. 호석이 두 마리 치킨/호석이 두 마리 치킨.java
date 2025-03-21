import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int road[][];

	public static void main(String[] args) throws IOException {
		readInput();
		floydWarshall();
		printAnswer();
	}

	static void readInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		road = new int[N + 1][N + 1];

		initRoad();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			road[A][B] = road[B][A] = 2;
		}

		br.close();
	}

	private static void initRoad() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				road[i][j] = 10000;

				if (i == j) {
					road[i][j] = 0;
				}
			}
		}
	}

	static void floydWarshall() {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					road[i][j] = Math.min(road[i][j], road[i][k] + road[k][j]);
				}
			}
		}
	}

	static void printAnswer() {
		int[] answer = new int[2];
		int minTime = Integer.MAX_VALUE;

		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				int totalTime = calculateTime(i, j);

				if (totalTime < minTime) {
					minTime = totalTime;
					answer[0] = i;
					answer[1] = j;
				}
			}
		}

		System.out.println(answer[0] + " " + answer[1] + " " + minTime);
	}

	private static int calculateTime(int i, int j) {
		int totalTime = 0;
		for (int k = 1; k <= N; k++) {
			totalTime += Math.min(road[i][k], road[j][k]);
		}
		return totalTime;
	}

}
