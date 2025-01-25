import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static PriorityQueue<Lecture> pq = new PriorityQueue<>();
	static boolean[] checked = new boolean[10001];

	public static void main(String[] args) throws Exception {
		input();
		int answer = calcMoney();
		System.out.println(answer);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int pay = Integer.parseInt(st.nextToken());
			int day = Integer.parseInt(st.nextToken());

			pq.add(new Lecture(pay, day));
		}

		br.close();
	}

	private static int calcMoney() {
		int moneySum = 0;
		while (!pq.isEmpty()) {
			Lecture l = pq.poll();

			for (int i = l.day; i > 0; i--) {
				if (!checked[i]) {
					checked[i] = true;
					moneySum += l.pay;
					break;
				}
			}
		}

		return moneySum;
	}

	static class Lecture implements Comparable<Lecture> {
		private int pay;
		private int day;

		public Lecture(int pay, int day) {
			this.pay = pay;
			this.day = day;
		}

		@Override
		public int compareTo(Lecture l) {
			if (this.pay == l.pay) {
				return this.day - l.day;
			}

			return l.pay - this.pay;
		}
	}

}
