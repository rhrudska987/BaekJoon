import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[] dataStructure = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			dataStructure[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (dataStructure[i] == 0) {
				q.offerFirst(num);
			}
		}

		int M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			q.offer(num);
			sb.append(q.poll()).append(" ");
		}

		System.out.println(sb.toString());
		br.close();
	}

}
