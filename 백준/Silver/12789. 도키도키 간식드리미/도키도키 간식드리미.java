import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] line = new int[N];
		for (int i = 0; i < N; i++) {
			line[i] = sc.nextInt();
		}

		Stack<Integer> st = new Stack<>();
		boolean niceCheck = true;
		int seq = 1;
		int idx = 0;
		while (true) {
			if (idx == N) {
				while (!st.isEmpty()) {
					if (st.peek() == seq) {
						st.pop();
						seq++;
					} else {
						niceCheck = false;
						break;
					}
				}
				break;
			}
			
			if (line[idx] == seq) {
				idx++;
				seq++;
				while (true) {
					if (!st.isEmpty() && st.peek() == seq) {
						st.pop();
						seq++;
					} else {
						break;
					}
				}
			} else {
				if (!st.isEmpty() && st.peek() < line[idx]) {
					niceCheck = false;
					break;
				}
				st.add(line[idx]);
				idx++;
			}
		}

		if (niceCheck) {
			System.out.println("Nice");
		} else {
			System.out.println("Sad");
		}

		sc.close();
	}

}
