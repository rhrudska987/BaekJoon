import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[] students;
	static boolean[] visited;
	static boolean[] finished;
	static int cnt = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			n = Integer.parseInt(br.readLine());
			students = new int[n + 1];
			visited = new boolean[n + 1];
			finished = new boolean[n + 1];
			cnt = 0;

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				students[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= n; i++) {
				dfs(i);
			}

			sb.append(n - cnt).append("\n");
		}

		System.out.println(sb.toString());
		br.close();
	}

	private static void dfs(int nowStudent) {
		if (visited[nowStudent]) {
			return;
		}

		visited[nowStudent] = true;
		int nextStudent = students[nowStudent];

		if (!visited[nextStudent]) {
			dfs(nextStudent);
		} else {
			if (!finished[nextStudent]) {
				cnt++;
				for (int i = nextStudent; i != nowStudent; i = students[i]) {
					cnt++;
				}
			}
		}

		finished[nowStudent] = true;
	}

}
