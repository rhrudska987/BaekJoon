import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);

		int x = Integer.parseInt(br.readLine());

		int left = 0;
		int right = n - 1;
		int cnt = 0;
		while (left < right) {
			int num = a[left] + a[right];

			if (num == x) {
				cnt++;
				left++;
				right--;
			} else if (num > x) {
				right--;
			} else {
				left++;
			}
		}

		System.out.println(cnt);
		br.close();
	}
}
