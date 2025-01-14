import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[] A = new int[N];
			int[] B = new int[M];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(A);
			Arrays.sort(B);

			int sum = 0;
			for (int i = 0; i < N; i++) {
				int idx = Arrays.binarySearch(B, A[i]);
				if (idx < 0) {
					idx = (idx * -1) - 1;
				}

				while (idx > 0 && idx < M && B[idx] == B[idx - 1]) {
					idx--;
				}

				sum += idx;
			}

			sb.append(sum + "\n");
		}

		System.out.println(sb);
		br.close();
	}

}
