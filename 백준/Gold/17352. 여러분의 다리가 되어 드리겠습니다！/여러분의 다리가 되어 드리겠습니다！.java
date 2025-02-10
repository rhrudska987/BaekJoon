import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());

		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < N - 2; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			union(x, y);
		}

		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= N; i++) {
			set.add(find(i));
		}

		for (int i : set) {
			System.out.print(i + " ");
		}

		br.close();
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y) {
			return;
		}

		if (x <= y) {
			parents[y] = x;
		} else {
			parents[x] = y;
		}
	}

	static int find(int x) {
		if (x == parents[x]) {
			return x;
		}

		return find(parents[x]);
	}

}
