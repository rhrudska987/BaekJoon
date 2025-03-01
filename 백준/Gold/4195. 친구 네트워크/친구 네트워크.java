import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int[] parents;
	static int[] ranks;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			Map<String, Integer> map = new HashMap<>();
			int F = Integer.parseInt(br.readLine());

			parents = new int[100001 * 2];
			ranks = new int[100001 * 2];
			for (int i = 1; i < 100001 * 2; i++) {
				parents[i] = i;
				ranks[i] = 1;
			}

			int idx = 1;
			for (int i = 0; i < F; i++) {
				st = new StringTokenizer(br.readLine());
				String name1 = st.nextToken();
				String name2 = st.nextToken();

				if (!map.containsKey(name1)) {
					map.put(name1, idx++);
				}

				if (!map.containsKey(name2)) {
					map.put(name2, idx++);
				}

				int count = union(map.get(name1), map.get(name2));
				sb.append(count).append("\n");
			}
		}

		System.out.println(sb);
		br.close();
	}

	private static int union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y) {
			return ranks[x];
		}

		if (x <= y) {
			parents[y] = x;
			ranks[x] += ranks[y];
			return ranks[x];
		} else {
			parents[x] = y;
			ranks[y] += ranks[x];
			return ranks[y];
		}
	}

	private static int find(int x) {
		if (parents[x] == x) {
			return x;
		}

		return find(parents[x]);
	}

}
