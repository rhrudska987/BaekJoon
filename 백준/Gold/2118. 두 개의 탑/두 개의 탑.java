import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int sum = 0;
		int[] points = new int[N + 1];
		for (int i = 0; i < N; i++) {
			points[i] = Integer.parseInt(br.readLine());
			sum += points[i];
		}

		int start = 0;
		int end = 0;

		int result = 0;
		int cur = points[start];

		while (start <= end && end < N) {
			int minCur = Math.min(cur, sum - cur);
			result = Math.max(result, minCur);

			if (cur == minCur) {
				end++;
				cur += points[end];
			} else {
				cur -= points[start];
				start++;
			}
		}

		System.out.println(result);
		br.close();
	}

}
