import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int parent[];
	static int childCnt[];

	static final int MOD = 1_000_000_007;

	public static void main(String[] args) throws Exception {
		readInput();
		long total = calcTotal();
		printAnswer(total);
	}

	private static long calcTotal() {
		long total = 1;

		for (int i = 1; i <= N; i++) {
			if (childCnt[i] == 0) {
				continue;
			}

			total = (total * childCnt[i]) % MOD;
		}

		return total;
	}

	private static void printAnswer(long total) {
		System.out.println(total % 1000000007);
	}

	private static void readInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		initParentAndChildCntArr();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			union(u, v);
		}

		br.close();
	}

	private static void initParentAndChildCntArr() {
		parent = new int[N + 1];
		childCnt = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			parent[i] = i;
			childCnt[i] = 1;
		}
	}

	private static boolean union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y) {
			return false;
		}

		if (x <= y) {
			parent[y] = x;
			childCnt[x] += childCnt[y];
			childCnt[y] = 0;
		} else {
			parent[x] = y;
			childCnt[y] += childCnt[x];
			childCnt[x] = 0;
		}

		return true;
	}

	private static int find(int x) {
		if (parent[x] == x) {
			return x;
		}

		return find(parent[x]);
	}

}
