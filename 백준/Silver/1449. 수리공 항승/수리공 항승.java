import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int cnt = 1;
		double range = arr[0] - 0.5 + L;
		for (int i = 1; i < N; i++) {
			if (range < arr[i] + 0.5) {
				range = arr[i] - 0.5 + L;
				cnt++;
			}
		}

		System.out.println(cnt);
		br.close();
	}

}
