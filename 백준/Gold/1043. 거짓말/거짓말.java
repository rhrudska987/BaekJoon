import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[] parent;
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		st = new StringTokenizer(br.readLine());
		int knowingPersonCnt = Integer.parseInt(st.nextToken());
		if (knowingPersonCnt == 0) {
			System.out.println(M);
			return;
		}

		for (int i = 0; i < knowingPersonCnt; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		List<Integer>[] partyList = new ArrayList[M];
		for (int i = 0; i < M; i++) {
			partyList[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int partyPeopleCnt = Integer.parseInt(st.nextToken());

			int x = Integer.parseInt(st.nextToken());
			partyList[i].add(x);
			for (int j = 1; j < partyPeopleCnt; j++) {
				int y = Integer.parseInt(st.nextToken());

				union(x, y);
				partyList[i].add(y);
			}
		}

		int partyCnt = 0;
		for (int i = 0; i < M; i++) {
			boolean flag = true;
			for (int j = 0; j < partyList[i].size(); j++) {
				if (list.contains(find(parent[partyList[i].get(j)]))) {
					flag = false;
					break;
				}
			}
			if (flag) {
				partyCnt++;
			}
		}

		System.out.println(partyCnt);
		br.close();
	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (list.contains(y)) {
			int tmp = x;
			x = y;
			y = tmp;
		}
		parent[y] = x;
	}

	private static int find(int x) {
		if (parent[x] == x) {
			return x;
		}

		return find(parent[x]);
	}

}
