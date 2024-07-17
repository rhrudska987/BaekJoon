import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();
		int K = sc.nextInt();

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}

		sb.append("<");
		int cnt = 1;
		while (q.size() != 1) {
			if (cnt == K) {
				sb.append(q.poll()).append(", ");
				cnt = 1;
			} else {
				int num = q.poll();
				q.add(num);
				cnt++;
			}
		}
		sb.append(q.poll()).append(">");
		System.out.println(sb.toString());

		sc.close();
	}

}
