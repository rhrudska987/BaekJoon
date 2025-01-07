import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static long[][] relationship;

	public static void main(String[] args) throws IOException {
		input();
		floydWarshall();
		printAnswer();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		relationship = new long[N + 1][N + 1];

		initRelationship();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			relationship[A][B] = relationship[B][A] = 1;
		}

		br.close();
	}

	static void initRelationship() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				relationship[i][j] = Integer.MAX_VALUE;

				if (i == j) {
					relationship[i][j] = 0;
				}
			}
		}
	}

	static void floydWarshall() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					relationship[j][k] = Math.min(relationship[j][k], relationship[j][i] + relationship[i][k]);
				}
			}
		}
	}

	static void printAnswer() {
		int min = Integer.MAX_VALUE;
		int minPerson = 0;
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= N; j++) {
				sum += relationship[i][j];
			}

			if (sum < min) {
				min = sum;
				minPerson = i;
			}
		}

		System.out.println(minPerson);
	}

}
