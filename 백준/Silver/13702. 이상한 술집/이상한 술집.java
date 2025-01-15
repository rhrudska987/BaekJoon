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

		long max = 0;
		int[] kettles = new int[N];
		for (int i = 0; i < N; i++) {
			kettles[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, kettles[i]);
		}

		long left = 1;
		long right = max;
		while (left <= right) {
			long mid = (left + right) / 2;

			int cnt = 0;
			for (int i = 0; i < N; i++) {
				cnt += kettles[i] / mid;
			}

			if (cnt < K) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}

		}

		System.out.println(right);
		br.close();
	}

}
