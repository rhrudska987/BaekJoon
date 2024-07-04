import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[][] X = new int[N][2];
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			X[i][0] = i;
			X[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(X, (o1, o2) -> {return o1[1] - o2[1];});
		
		int[] ans = new int[N];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			ans[X[i][0]] = cnt;
			while (i + 1 < N && X[i][1] == X[i + 1][1]) {
				i++;
				ans[X[i][0]] = cnt;
			}
			cnt++;
		}
		
		for (int i = 0; i < N; i++) {
			sb.append(ans[i] + " ");
		}
		System.out.println(sb.toString());
		br.close();
	}

}
