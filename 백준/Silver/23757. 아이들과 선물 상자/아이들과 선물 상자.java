import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static PriorityQueue<Integer> cpq = new PriorityQueue<>(Collections.reverseOrder());
	static Queue<Integer> wq = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		input();
		int result = comparePresentAndChild();
		printAnswer(result);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cpq.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			wq.add(Integer.parseInt(st.nextToken()));
		}

		br.close();
	}

	private static int comparePresentAndChild() {
		while (!wq.isEmpty()) {
			int c = cpq.poll();
			int w = wq.poll();

			if (w > c) {
				return 0;
			}

			cpq.add(c - w);
		}

		return 1;
	}

	private static void printAnswer(int result) {
		System.out.println(result);
	}

}
