import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static final int[] dx = {-1, 0, 1, 0};
	static final int[] dy = {0, -1, 0, 1};
	static int R;
	static int C;
	static String[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		ArrayDeque<int[]> personQueue = new ArrayDeque<>();
		ArrayDeque<int[]> fireQueue = new ArrayDeque<>();

		visited = new boolean[R][C];
		map = new String[R][C];
		int landCnt = 0;
		for (int i = 0; i < R; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < C; j++) {
				map[i][j] = str[j];
				if (map[i][j].equals(".")) {
					landCnt++;
				}
				if (map[i][j].equals("J")) {
					personQueue.add(new int[] {j, i});
					visited[i][j] = true;
					landCnt++;
				} else if (map[i][j].equals("F")) {
					fireQueue.add(new int[] {j, i});
				}
			}
		}

		int ans = 0;
		end: while (true) {
			ArrayDeque<int[]> ad = new ArrayDeque<>();
			//모두 불타고 있으면 IMPOSSIBLE
			if (landCnt == 0) {
				System.out.println("IMPOSSIBLE");
				break;
			}

			//불 확산
			while (!fireQueue.isEmpty()) {
				int[] firePoint = fireQueue.poll();
				for (int i = 0; i < 4; i++) {
					int nextX = firePoint[0] + dx[i];
					int nextY = firePoint[1] + dy[i];
					if (0 <= nextX && nextX < C && 0 <= nextY && nextY < R && (map[nextY][nextX].equals(".")
						|| map[nextY][nextX].equals("J"))) {
						map[nextY][nextX] = "F";
						ad.add(new int[] {nextX, nextY});
					}
				}
			}
			landCnt -= ad.size();
			fireQueue.addAll(ad);
			ad = new ArrayDeque<>();

			//사람 이동
			while (!personQueue.isEmpty()) {
				int[] personPoint = personQueue.poll();
				for (int i = 0; i < 4; i++) {
					int nextX = personPoint[0] + dx[i];
					int nextY = personPoint[1] + dy[i];

					if (nextX < 0 || nextX >= C || nextY < 0 || nextY >= R) {
						System.out.println(ans + 1);
						break end;
					}

					if (0 <= nextX && nextX < C && 0 <= nextY && nextY < R && map[nextY][nextX].equals(".")
						&& !visited[nextY][nextX]) {
						visited[nextY][nextX] = true;
						ad.add(new int[] {nextX, nextY});
					}
				}
			}
			
			if (ad.size() == 0) {
				System.out.println("IMPOSSIBLE");
				break;
			}

			personQueue.addAll(ad);
			ans++;
		}

		br.close();
	}
}
