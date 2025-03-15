import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, K;
	static int[] visited = new int[100001];

	public static void main(String[] args) {
		readInput();
		initVisited();

		int totalTime = bfs();
		if (totalTime == 0) {
			System.out.println(0);
			System.out.println(N);
			return;
		}

		int[] route = findRoute(totalTime);
		printAnswer(totalTime, route);
	}

	private static void readInput() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		sc.close();
	}

	private static void initVisited() {
		for (int i = 0; i < 100001; i++) {
			visited[i] = Integer.MAX_VALUE;
		}
	}

	private static int bfs() {
		int totalTime = 0;

		Queue<Point> q = new LinkedList<>();
		q.add(new Point(N, 0));
		visited[N] = 0;

		while (!q.isEmpty()) {
			Point p = q.poll();

			if (p.x == K) {
				totalTime = p.time;
				break;
			}

			if (p.x - 1 >= 0 && visited[p.x - 1] == Integer.MAX_VALUE) {
				visited[p.x - 1] = p.time + 1;
				q.add(new Point(p.x - 1, p.time + 1));
			}
			if (p.x + 1 <= 100000 && visited[p.x + 1] == Integer.MAX_VALUE) {
				visited[p.x + 1] = p.time + 1;
				q.add(new Point(p.x + 1, p.time + 1));
			}
			if (p.x * 2 <= 100000 && visited[p.x * 2] == Integer.MAX_VALUE) {
				visited[p.x * 2] = p.time + 1;
				q.add(new Point(p.x * 2, p.time + 1));
			}
		}

		return totalTime;
	}

	private static int[] findRoute(int totalTime) {
		int[] route = new int[totalTime + 1];
		route[0] = K;

		for (int i = 1; i <= totalTime; i++) {
			int prevPoint = route[i - 1];
			int curTime = totalTime - i;
			if (prevPoint % 2 == 0 && visited[prevPoint / 2] == curTime) {
				route[i] = prevPoint / 2;
			} else if (prevPoint - 1 >= 0 && visited[prevPoint - 1] == curTime) {
				route[i] = prevPoint - 1;
			} else if (prevPoint + 1 <= 100000 && visited[prevPoint + 1] == curTime) {
				route[i] = prevPoint + 1;
			}
		}

		return route;
	}

	private static void printAnswer(int totalTime, int[] route) {
		StringBuilder sb = new StringBuilder();
		sb.append(totalTime).append("\n");

		for (int i = totalTime; i >= 0; i--) {
			sb.append(route[i]).append(" ");
		}

		System.out.println(sb);
	}

	private static class Point {
		int x;
		int time;

		public Point(int x, int time) {
			this.x = x;
			this.time = time;
		}
	}

}
