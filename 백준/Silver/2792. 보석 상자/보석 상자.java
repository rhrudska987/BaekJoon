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

		int[] jewel = new int[M];
		int jewelMax = 0;
		for (int i = 0; i < M; i++) {
			jewel[i] = Integer.parseInt(br.readLine());
			jewelMax = Math.max(jewelMax, jewel[i]);
		}

		int left = 1;
		int right = jewelMax;
		int ans = 0;
		while (left <= right) {
			int mid = (right + left) / 2;

			int personCnt = 0;
			for (int i = 0; i < M; i++) {
				if (jewel[i] % mid == 0) {
					personCnt += jewel[i] / mid;
				} else {
					personCnt += jewel[i] / mid + 1;
				}
			}

			if (personCnt > N) {
				left = mid + 1;
			} else {
				right = mid - 1;
				ans = mid;
			}
		}

		System.out.println(ans);
		br.close();
	}

}
