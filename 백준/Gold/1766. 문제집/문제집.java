import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<ArrayList<Integer>> list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		int[] indegree = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			list.get(A).add(B);
			indegree[B]++;
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				pq.add(i);
			}
		}

		while (!pq.isEmpty()) {
			int problem = pq.poll();
			sb.append(problem + " ");

			for (int i : list.get(problem)) {
				if (--indegree[i] == 0) {
					pq.add(i);
				}
			}
		}

		System.out.println(sb.toString());
		br.close();
	}
}
