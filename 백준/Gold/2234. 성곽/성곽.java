import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};

	static int N, M;
	static int[][] castle;
	static int[][] roomMap;
	static Map<Integer, Integer> roomSizeInfo = new HashMap<>();

	static int roomCnt = 0;
	static int maxRoomSize = 0;
	static int breakWallMaxRoomSize = 0;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		readInput();
		findRoomCntAndMaxSize();
		for (int i = 1; i <= roomCnt; i++) {
			breakWallAndFindMaxRoomSize(i);
		}
		printAnswer();
	}

	private static void readInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		castle = new int[M][N];
		roomMap = new int[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				castle[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		br.close();
	}

	private static void findRoomCntAndMaxSize() {
		boolean[][] visited = new boolean[M][N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					visited[i][j] = true;
					roomCnt++;
					int roomSize = calcRoomSize(i, j, visited);
					roomSizeInfo.put(roomCnt, roomSize);
					maxRoomSize = Math.max(maxRoomSize, roomSize);
				}
			}
		}
	}

	private static int calcRoomSize(int y, int x, boolean[][] visited) {
		int roomSize = 1;

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {y, x});
		roomMap[y][x] = roomCnt;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int ny = cur[0] + dy[i];
				int nx = cur[1] + dx[i];

				if (ny < 0 || ny >= M || nx < 0 || nx >= N || visited[ny][nx] || (castle[cur[0]][cur[1]] & (1 << i)) != 0) {
					continue;
				}

				visited[ny][nx] = true;
				roomMap[ny][nx] = roomCnt;
				roomSize++;
				queue.add(new int[] {ny, nx});
			}
		}

		return roomSize;
	}

	private static void breakWallAndFindMaxRoomSize(int roomNumber) {
		boolean[][] visited = new boolean[M][N];
		for (int y = 0; y < M; y++) {
			for (int x = 0; x < N; x++) {
				visited[y][x] = true;

				if (roomMap[y][x] != roomNumber) {
					continue;
				}

				for (int i = 0; i < 4; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];

					if (ny < 0 || ny >= M || nx < 0 || nx >= N || roomMap[ny][nx] == roomNumber || visited[ny][nx]) {
						continue;
					}

					breakWallMaxRoomSize = Math.max(breakWallMaxRoomSize, roomSizeInfo.get(roomNumber) + roomSizeInfo.get(roomMap[ny][nx]));
				}
			}
		}
	}

	private static void printAnswer() {
		StringBuilder sb = new StringBuilder();
		sb.append(roomCnt).append("\n");
		sb.append(maxRoomSize).append("\n");
		sb.append(breakWallMaxRoomSize).append("\n");
		System.out.println(sb);
	}
}
