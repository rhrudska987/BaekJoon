import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] points;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		points = new int[N];
		for (int i = 0; i < N; i++) {
			points[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(points);

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int startP = Integer.parseInt(st.nextToken());
			int endP = Integer.parseInt(st.nextToken());

			int a = leftBinarySearch(startP);
			int b = rightBinarySearch(endP);

			sb.append(b - a + "\n");
		}

		System.out.println(sb);
		br.close();
	}

	static int leftBinarySearch(int key) {
		int left = 0;
		int right = N - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (key <= points[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return left;
	}

	static int rightBinarySearch(int key) {
		int left = 0;
		int right = N - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (key < points[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return right + 1;
	}

}
