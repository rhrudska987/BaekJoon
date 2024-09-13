import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long k = Long.parseLong(st.nextToken());

		long left = 0;
		long right = n;
		boolean find = false;
		while (left <= right) {
			long mid = (left + right) / 2;
			long totalCnt = 1 + n + (n - mid) * mid;

			if (totalCnt == k) {
				find = true;
				break;
			} else if (totalCnt > k) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}

		}

		if (find) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

		br.close();
	}

}
