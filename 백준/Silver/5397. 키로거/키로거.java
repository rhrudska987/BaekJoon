import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			String[] input = br.readLine().split("");
			ArrayDeque<String> left = new ArrayDeque<>();
			ArrayDeque<String> right = new ArrayDeque<>();

			for (int i = 0; i < input.length; i++) {
				if (input[i].equals("<") && !left.isEmpty()) {
					right.addFirst(left.pollLast());
				} else if (input[i].equals(">") && !right.isEmpty()) {
					left.addLast(right.pollFirst());
				} else if (input[i].equals("-") && !left.isEmpty()) {
					left.pollLast();
				} else if (!input[i].equals(">") && !input[i].equals("<") && !input[i].equals("-")) {
					left.add(input[i]);
				}
			}

			while (!left.isEmpty()) {
				sb.append(left.pollFirst());
			}

			while (!right.isEmpty()) {
				sb.append(right.pollFirst());
			}

			sb.append("\n");
		}

		System.out.println(sb.toString());
		br.close();
	}
}
