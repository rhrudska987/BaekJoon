import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] scores;
	static PriorityQueue<growth> growths;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()) * 24;
		M = Integer.parseInt(st.nextToken());

		scores = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			scores[i] = Integer.parseInt(st.nextToken());
		}

		growths = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int number = Integer.parseInt(st.nextToken());
			growths.add(new growth(i, number));
		}

		while(N > 0 && !growths.isEmpty()) {
			growth p = growths.poll();
			int time = ((100 - scores[p.id]) / p.number);
			int realTime = Math.min(N, time);

			N -= realTime;
			scores[p.id] += p.number * realTime;

			if(scores[p.id] != 100) {
				growths.add(new growth(p.id, 100 - scores[p.id]));
			}

		}

		int answer = 0;
		for (int i = 0; i < M; i++) {
			answer += scores[i];
		}

		System.out.println(answer);

	}

	public static class growth implements Comparable<growth> {
		int id;
		int number;

		growth(int id, int number) {
			this.id = id;
			this.number = number;
		}

		public int compareTo(growth g) {
			return g.number - this.number;
		}

	}

}
