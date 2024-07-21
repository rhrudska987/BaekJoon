import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long maxT = 0;
		int[] T = new int[N];
		for (int i = 0; i < N; i++) {
			T[i] = Integer.parseInt(br.readLine());
			maxT = Math.max(maxT, T[i]);
		}

		Arrays.sort(T);
		long right = maxT * M;
		long left = 0;

		while (left < right) {
			long mid = (left + right) / 2;

			long sum = 0;
			for (int i = 0; i < N; i++) {
				sum += mid / T[i];
				if (sum > M) {
					break;
				}
			}

			if (sum < M) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		System.out.println(left);
	}

}
