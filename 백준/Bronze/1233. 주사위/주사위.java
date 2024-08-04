import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S1 = Integer.parseInt(st.nextToken());
		int S2 = Integer.parseInt(st.nextToken());
		int S3 = Integer.parseInt(st.nextToken());

		int[] arr = new int[S1 + S2 + S3 + 1];

		for (int i = 1; i <= S1; i++) {
			for (int j = 1; j <= S2; j++) {
				for (int k = 1; k <= S3; k++) {
					arr[i + j + k]++;
				}
			}
		}

		int cnt = 0;
		int max = 0;
		for (int i = 1; i < arr.length; i++) {
			if (cnt < arr[i]) {
				cnt = arr[i];
				max = i;
			}
		}

		System.out.println(max);
		br.close();
	}

}
