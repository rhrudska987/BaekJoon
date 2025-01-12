import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long max = Integer.MAX_VALUE;
		long min = Integer.MAX_VALUE;

		int[] X = new int[N];
		for (int i = 0; i < N; i++) {
			X[i] = Integer.parseInt(br.readLine());
			min = Math.min(min, X[i]);
		}

		long result = 0;
		while (min <= max) {
			long mid = (min + max) / 2;
			long sum = 0;
			for (int i = 0; i < N; i++) {
				if (X[i] <= mid) {
					sum += mid - X[i];
				}
			}
			if (sum <= K) {
				result = Math.max(result, mid);
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}

		System.out.println(result);
	}

}
