import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		int[][] line = new int[M][3];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			line[i][0] = Integer.parseInt(st.nextToken());
			line[i][1] = Integer.parseInt(st.nextToken());
			line[i][2] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(line, (o1, o2) -> Integer.compare(o1[2], o2[2]));

		int totalCost = 0;
		for (int i = 0; i < M; i++) {
			if (union(line[i][0], line[i][1])) {
				totalCost += line[i][2];
			}
		}

		System.out.println(totalCost);
		br.close();
	}

	static int find(int x) {
		if (x == parent[x]) {
			return x;
		}

		return parent[x] = find(parent[x]);
	}

	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			if (x < y) {
				parent[y] = x;
			} else {
				parent[x] = y;
			}
			return true;
		}

		return false;
	}
}
