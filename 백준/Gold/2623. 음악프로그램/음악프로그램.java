import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] edgeCount;
	static List<Integer>[] graph;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		readInput();
		topologicalSort();
		printAnswer();
	}

	private static void readInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		edgeCount = new int[N + 1];
		initGraph();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int singerCount = Integer.parseInt(st.nextToken());
			int firstSingerNo = Integer.parseInt(st.nextToken());

			for (int j = 0; j < singerCount - 1; j++) {
				int nextSingerNo = Integer.parseInt(st.nextToken());
				graph[firstSingerNo].add(nextSingerNo);
				edgeCount[nextSingerNo]++;
				firstSingerNo = nextSingerNo;
			}
		}

		br.close();
	}

	private static void initGraph() {
		graph = new List[N + 1];

		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
	}

	private static void topologicalSort() {
		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (edgeCount[i] == 0) {
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			int curNodeNo = q.poll();
			sb.append(curNodeNo + "\n");

			for (int i = 0; i < graph[curNodeNo].size(); i++) {
				int nodeNo = graph[curNodeNo].get(i);
				edgeCount[nodeNo]--;

				if (edgeCount[nodeNo] == 0) {
					q.add(nodeNo);
				}
			}
		}
	}

	private static void printAnswer() {
		for (int i = 1; i <= N; i++) {
			if (edgeCount[i] != 0) {
				System.out.println(0);
				return;
			}
		}
		
		System.out.println(sb);
	}
}
