import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] a = new int[N];
		int[] b = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(a);
		Arrays.sort(b);

		long hiWin = 0;
		long draw = 0;
		long arcWin = 0;

		for (int i = 0; i < N; i++) {
			int target = a[i];

			// 무승부인 지점을 찾기 위한 이분 탐색
			int leftIdx = findLeftIndex(b, target);
			int rightIdx = findRightIndex(b, target);

			hiWin += leftIdx;
			draw += (rightIdx - leftIdx + 1);
			arcWin += (M - rightIdx - 1);
		}

		System.out.println(hiWin + " " + arcWin + " " + draw);
	}

	private static int findLeftIndex(int[] arc, int target) {
		int s = 0, e = arc.length - 1;
		int leftIdx = arc.length;

		while (s <= e) {
			int mid = (s + e) / 2;

			if (arc[mid] >= target) {
				leftIdx = mid;
				e = mid - 1;
			} else {
				s = mid + 1;
			}
		}
		return leftIdx;
	}

	private static int findRightIndex(int[] arc, int target) {
		int s = 0, e = arc.length - 1;
		int rightIdx = -1;

		while (s <= e) {
			int mid = (s + e) / 2;

			if (arc[mid] <= target) {
				rightIdx = mid;
				s = mid + 1;
			} else {
				e = mid - 1;
			}
		}
		return rightIdx;
	}

}
