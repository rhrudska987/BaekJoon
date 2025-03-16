import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] A = new int[n];
		int[] B = new int[n];
		int[] C = new int[n];
		int[] D = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			D[i] = Integer.parseInt(st.nextToken());
		}

		int[] AB = new int[n * n];
		int[] CD = new int[n * n];

		int idx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				AB[idx] = A[i] + B[j];
				CD[idx] = C[i] + D[j];
				idx++;
			}
		}

		Arrays.sort(AB);
		Arrays.sort(CD);

		long count = 0;
		int left = 0;
		int right = n * n - 1;
		while (left < n * n && right >= 0) {
			int sum = AB[left] + CD[right];

			if (sum < 0) {
				left++;
			} else if (sum > 0) {
				right--;
			} else {
				long leftCnt = 1;
				long rightCnt = 1;

				while (left < n * n - 1 && AB[left] == AB[left + 1]) {
					leftCnt++;
					left++;
				}

				while (right > 0 && CD[right] == CD[right - 1]) {
					rightCnt++;
					right--;
				}

				count += leftCnt * rightCnt;
				left++;
				right--;
			}
		}

		System.out.println(count);
		br.close();
	}

}
