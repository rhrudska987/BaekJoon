import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();

		int[] number = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			number[i] = sc.nextInt();
		}

		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}

		int num = q.poll();
		int curNum = number[1];
		sb.append(num).append(" ");
		
		while (!q.isEmpty()) {
			if (curNum > 0) {
				while (curNum > 1) {
					q.offer(q.poll());
					curNum--;
				}
			} else {
				while (curNum < 0) {
					q.offerFirst(q.pollLast());
					curNum++;
				}
			}

			int bomb = q.poll();
			sb.append(bomb).append(" ");
			curNum = number[bomb];
		}

		System.out.println(sb.toString());
		sc.close();
	}

}
