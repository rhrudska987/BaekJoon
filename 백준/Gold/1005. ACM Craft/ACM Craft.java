import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int[] times = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				times[i] = Integer.parseInt(st.nextToken());
			}

			int[] edgeCount = new int[N + 1];
			List<Integer>[] graph = new List[N + 1];
			for (int i = 1; i <= N; i++) {
				graph[i] = new ArrayList<>();
			}

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				graph[X].add(Y);
				edgeCount[Y]++;
			}

			int W = Integer.parseInt(br.readLine());

			List<Integer> list = new ArrayList<>();
			for (int i = 1; i <= N; i++) {
				if (edgeCount[i] == 0) {
					list.add(i);
				}
			}

			Queue<Integer> q = new LinkedList<>();
			int time = 0;
			while (true) {
				if (times[W] == 0) {
					break;
				}

				time++;

				boolean isZero = false;
				for (int nodeNo : list) {
					times[nodeNo]--;

					if (times[nodeNo] == 0) {
						isZero = true;
						q.add(nodeNo);
					}
				}

				if (isZero) {
					while (!q.isEmpty()) {
						int curNodeNo = q.poll();

						for (int nodeNo : graph[curNodeNo]) {
							if (--edgeCount[nodeNo] == 0) {
								list.add(nodeNo);
							}
						}

						list.remove((Integer)curNodeNo);
					}
				}
			}

			sb.append(time).append("\n");
		}

		System.out.println(sb);
		br.close();
	}

}
