import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static final int[] dx = {-1, 0, 1, 0};
	static final int[] dy = {0, -1, 0, 1};
	static int R;
	static int C;
	static String[][] map;
	static Set<String> set = new HashSet<>();
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new String[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().split("");
		}

		set.add(map[0][0]);
		max = 1;
		dfs(0, 0, 1);

		System.out.println(max);
	}

	static void dfs(int y, int x, int cnt) {
		max = Math.max(max, cnt);
		for (int i = 0; i < 4; i++) {
			int nextY = y + dy[i];
			int nextX = x + dx[i];

			if (0 <= nextY && nextY < R && 0 <= nextX && nextX < C && !set.contains(map[nextY][nextX])) {
				set.add(map[nextY][nextX]);
				dfs(nextY, nextX, cnt + 1);
				set.remove(map[nextY][nextX]);
			}
		}
	}
}
