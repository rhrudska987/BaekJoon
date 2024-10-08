import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] liquid = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			liquid[i] = Integer.parseInt(st.nextToken());
		}

		int min = Integer.MAX_VALUE;
		int left = 0;
		int right = liquid.length - 1;
		while (left < right) {
			int sumLiquid = liquid[left] + liquid[right];
			if (sumLiquid < 0) {
				if (Math.abs(sumLiquid) < Math.abs(min)) {
					min = sumLiquid;
				}
				left++;
			} else if (sumLiquid > 0) {
				if (Math.abs(sumLiquid) < Math.abs(min)) {
					min = sumLiquid;
				}
				right--;
			} else {
				min = 0;
				break;
			}
		}

		System.out.println(min);
	}

}
