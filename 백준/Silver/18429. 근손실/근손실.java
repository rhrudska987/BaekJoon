import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int[] kits;
	static boolean[] visited;
	static int answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		kits = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			kits[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 500);

		System.out.println(answer);
		br.close();
	}

	static void dfs(int day, int weight) {
		if (day == N) {
			answer++;
			return;
		}

		if (weight < 500) {
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i]) {
				continue;
			}

			visited[i] = true;
			dfs(day + 1, weight + kits[i] - K);
			visited[i] = false;
		}

	}

}
