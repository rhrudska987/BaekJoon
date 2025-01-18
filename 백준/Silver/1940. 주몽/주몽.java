import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int[] materials = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			materials[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(materials);

		int cnt = 0;
		int l = 0;
		int r = N - 1;
		while (l < r) {
			int sum = materials[l] + materials[r];
			if (sum > M) {
				r--;
			} else if (sum < M) {
				l++;
			} else {
				l++;
				r--;
				cnt++;
			}
		}

		System.out.println(cnt);
		br.close();
	}

}
