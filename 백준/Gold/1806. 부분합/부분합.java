import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		int[] sequence = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			sequence[i] = Integer.parseInt(st.nextToken());
		}

		int min = Integer.MAX_VALUE;
		int start = 0;
		int end = 0;
		int sum = sequence[end];
		while (true) {
			if (sum >= S) {
				min = Math.min(min, end - start + 1);
				sum -= sequence[start];
				start++;
			} else {
				end++;
				if (end >= N) {
					break;
				}
				sum += sequence[end];
			}
		}

		if (min == Integer.MAX_VALUE) {
			System.out.println(0);
		} else {
			System.out.println(min);
		}
		br.close();
	}
}
