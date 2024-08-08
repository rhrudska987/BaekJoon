import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] seq = new int[M];
		for (int i = 0; i < M; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}

		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}

		int answer = 0;
		for (int i = 0; i < M; i++) {
			ArrayDeque<Integer> copyQ1 = new ArrayDeque<>(q);
			ArrayDeque<Integer> copyQ2 = new ArrayDeque<>(q);
			int cnt1 = 0;
			int cnt2 = 0;

			while (copyQ1.peek() != seq[i]) {
				cnt1++;
				copyQ1.poll();
			}

			while (copyQ2.peekLast() != seq[i]) {
				cnt2++;
				copyQ2.pollLast();
			}

			if (cnt1 <= cnt2) {
				for (int j = 0; j < cnt1; j++) {
					q.offer(q.poll());
				}
				q.poll();
				answer += cnt1;
			} else {
				for (int j = 0; j < cnt2; j++) {
					q.offerFirst(q.pollLast());
				}
				q.pollLast();
				answer += cnt2 + 1;
			}

		}

		System.out.println(answer);
		br.close();
	}

}
