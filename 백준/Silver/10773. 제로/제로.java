import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayDeque<Integer> q = new ArrayDeque<>();

		int K = Integer.parseInt(br.readLine());
		while (K-- > 0) {
			int num = Integer.parseInt(br.readLine());

			if (num > 0) {
				q.offer(num);
			} else {
				if (!q.isEmpty()) {
					q.pollLast();
				}
			}
		}

		int sum = 0;
		while (!q.isEmpty()) {
			sum += q.pop();
		}

		System.out.println(sum);
	}
}
