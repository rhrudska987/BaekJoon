import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int answer = 0;

		int n = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if (stack.isEmpty()) {
				stack.push(y);
				continue;
			}

			while (!stack.isEmpty() && stack.peek() > y) {
				int popNumber = stack.pop();

				while (!stack.isEmpty() && stack.peek() == popNumber) {
					stack.pop();
				}
				answer++;

			}

			if (y == 0) {
				continue;
			}

			stack.push(y);
		}

		while (!stack.isEmpty()) {
			int popNumber = stack.pop();

			if (popNumber == 0) {
				continue;
			}

			while (!stack.isEmpty() && stack.peek() == popNumber) {
				stack.pop();
			}
			answer++;
		}

		System.out.println(answer);
		br.close();
	}

}
