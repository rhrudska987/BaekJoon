import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(st.nextToken()));
		}

		int time = 0;
		while (!pq.isEmpty()) {
			int cur = pq.poll();
			time += cur;
			
			for (int i = 1; i < M; i++) {
				int sum = 0;
				
				while (!pq.isEmpty() && cur != sum) {
					sum += pq.poll();
				}
			}
		}

		System.out.println(time);
		br.close();
	}

}
