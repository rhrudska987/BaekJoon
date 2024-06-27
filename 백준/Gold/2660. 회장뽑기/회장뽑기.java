import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int[][] group = new int[N + 1][N + 1];
		while (true) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());

			if (i == -1 && j == -1) {
				break;
			}

			group[i][j] = 1;
			group[j][i] = 1;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) {
					group[i][j] = 1;
				}
				if (group[i][j] == 0) {
					group[i][j] = 10000;
				}
			}
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					group[i][j] = Math.min(group[i][j], group[i][k] + group[k][j]);
				}
			}
		}

		List<Integer> list = new ArrayList<>();
		list.add(Integer.MAX_VALUE);
		for (int i = 1; i <= N; i++) {
			int dist = Integer.MIN_VALUE;

			for (int j = 1; j <= N; j++) {
				dist = Math.max(dist, group[i][j]);
			}

			if (list.get(0) > dist) {
				list.clear();
				list.add(dist);
				list.add(i);
			} else if (list.get(0) == dist) {
				list.add(i);
			}
		}

		System.out.print(list.get(0) + " ");
		list.remove(0);
		System.out.println(list.size());

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();

		br.close();
	}
}
