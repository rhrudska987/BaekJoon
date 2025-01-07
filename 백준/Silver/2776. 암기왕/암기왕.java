import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] note1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			note1 = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				note1[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(note1);

			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				int num = Integer.parseInt(st.nextToken());

				if (binarySearch(num)) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
			}
		}

		System.out.println(sb);

	}

	static boolean binarySearch(int num) {
		int left = 0;
		int right = N - 1;
		while (left <= right) {
			int mid = (left + right) / 2;

			if (note1[mid] == num) {
				return true;
			} else if (note1[mid] < num) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return false;
	}

}
