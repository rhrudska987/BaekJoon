import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			union(x, y);
		}

		int cnt = 0;
		st = new StringTokenizer(br.readLine());
		int beforeClass = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			int nowClass = Integer.parseInt(st.nextToken());
			if (find(beforeClass) != find(nowClass)) {
				cnt++;
			}
			beforeClass = nowClass;
		}

		System.out.println(cnt);
		br.close();
	}

	static int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		return find(parent[x]);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			if (y > x) {
				parent[y] = x;
			} else {
				parent[x] = y;
			}
		}
	}

}
