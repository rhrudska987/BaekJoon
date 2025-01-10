import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] holeSizeArr = new int[N];
		for (int i = 0; i < N; i++) {
			holeSizeArr[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = 0;
		int sum = 0;
		int maxSum = 0;
		while (end < N) {
			sum += holeSizeArr[end++];
			while (sum > M) {
				sum -= holeSizeArr[start++];
			}

			maxSum = Math.max(maxSum, sum);
		}

		System.out.println(maxSum);
		br.close();
	}

}
