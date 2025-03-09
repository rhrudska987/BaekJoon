import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int[] x = new int[N];
		int[] y = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}

		double sum = 0;
		for (int i = 0; i < N; i++) {
			sum += (double) x[i] * y[(i + 1) % N];
			sum -= (double) x[(i + 1) % N] * y[i];
		}

		System.out.printf("%.1f", Math.abs(sum / 2));
		br.close();
	}

}
