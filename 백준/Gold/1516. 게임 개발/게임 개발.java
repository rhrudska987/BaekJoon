import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		List<Integer>[] graph = new List[N + 1];
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		int[] edgeCount = new int[N + 1];
		int[] buildTimes = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			String[] input = br.readLine().split(" ");
			buildTimes[i] = Integer.parseInt(input[0]);
			for (int j = 1; j < input.length - 1; j++) {
				int nodeNo = Integer.parseInt(input[j]);
				graph[nodeNo].add(i);
				edgeCount[i]++;
			}
		}

		int[] answer = new int[N + 1];
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (edgeCount[i] == 0) {
				q.add(i);
				answer[i] = buildTimes[i];
			}
		}

		while (!q.isEmpty()) {
			int curNodeNo = q.poll();

			for (int nextNodeNo : graph[curNodeNo]) {
				answer[nextNodeNo] = Math.max(answer[nextNodeNo], answer[curNodeNo] + buildTimes[nextNodeNo]);

				if (--edgeCount[nextNodeNo] == 0) {
					q.add(nextNodeNo);
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			System.out.println(answer[i]);
		}

		br.close();
	}

}