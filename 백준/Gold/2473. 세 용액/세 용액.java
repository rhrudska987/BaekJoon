import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long[] solution = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			solution[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(solution);
		long[] answer = new long[3];

		long min = Long.MAX_VALUE;
		for (int i = 0; i < N - 2; i++) {
			int left = i;
			int mid = i + 1;
			int right = N - 1;

			while (mid < right) {
				long sum = solution[left] + solution[mid] + solution[right];

				if (Math.abs(sum) < min) {
					min = Math.abs(sum);
					answer[0] = solution[left];
					answer[1] = solution[mid];
					answer[2] = solution[right];
				}

				if (sum < 0) {
					mid++;
				} else if (sum > 0) {
					right--;
				} else {
					break;
				}
			}
		}

		System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
		br.close();
	}

}
