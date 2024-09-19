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
		int L = Integer.parseInt(st.nextToken());

		int[] restArea = new int[N + 2];
		restArea[0] = 0;
		restArea[N + 1] = L;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			restArea[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(restArea);

		int answer = L;
		int left = 1;
		int right = L - 1;
		while (left <= right) {
			int mid = (left + right) / 2;

			int cnt = 0;
			for (int i = 0; i < N + 1; i++) {
				int dist = restArea[i + 1] - restArea[i];
				cnt += dist / mid;

				if (dist % mid == 0) {
					cnt--;
				}
			}

			if (cnt > M) {
				left = mid + 1;
			} else if (cnt <= M) {
				right = mid - 1;
				answer = mid;
			}
		}
		
		System.out.println(answer);
		br.close();
	}

}
