import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] students = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			students[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(students);

		int ans = 0;
		int left = 0;
		int right = N - 1;
		while (left < right) {
			int sum = students[left] + students[right];
			if (sum >= M) {
				right--;
				left++;
				ans++;
			} else {
				left++;
			}
		}

		System.out.println(ans);
	}

}
