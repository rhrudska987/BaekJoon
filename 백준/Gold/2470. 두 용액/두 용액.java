import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] solution = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			solution[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(solution);

		int left = 0;
		int right = N - 1;
		int min = Integer.MAX_VALUE;
		int liquid1 = -1;
		int liquid2 = -1;
		while (left < right) {
			int sum = Math.abs(solution[left] + solution[right]);

			if (min > sum) {
				liquid1 = solution[left];
				liquid2 = solution[right];
				min = sum;
			}

			if (Math.abs(solution[right] + solution[left + 1]) > Math.abs(solution[left] + solution[right - 1])) {
				right--;
			} else {
				left++;
			}
		}

		System.out.println(liquid1 + " " + liquid2);
		br.close();
	}
}
