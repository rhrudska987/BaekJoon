import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static Stack<Character> leftStack = new Stack<>();
	static Stack<Character> rightStack = new Stack<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		String[] origin = br.readLine().split("");
		for (int i = 0; i < origin.length; i++) {
			leftStack.add(origin[i].charAt(0));
		}

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if (command.equals("L")) {
				L();
			} else if (command.equals("D")) {
				D();
			} else if (command.equals("B")) {
				B();
			} else {
				P(st.nextToken().charAt(0));
			}
		}

		for (int i = 0; i < leftStack.size(); i++) {
			char c = leftStack.pop();
			rightStack.add(c);
		}

		while (!leftStack.isEmpty()) {
			rightStack.add(leftStack.pop());
		}
		while (!rightStack.isEmpty()) {
			sb.append(rightStack.pop());
		}
		System.out.println(sb);
	}

	static void L() {
		if (!leftStack.isEmpty()) {
			rightStack.add(leftStack.pop());
		}
	}

	static void D() {
		if (!rightStack.isEmpty()) {
			leftStack.add(rightStack.pop());
		}
	}

	static void B() {
		if (!leftStack.isEmpty()) {
			leftStack.pop();
		}
	}

	static void P(char word) {
		leftStack.add(word);
	}

}