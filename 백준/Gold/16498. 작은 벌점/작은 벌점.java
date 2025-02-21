import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[] ACards = new int[A];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < A; i++) {
			ACards[i] = Integer.parseInt(st.nextToken());
		}

		int[] BCards = new int[B];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < B; i++) {
			BCards[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(BCards);

		int[] CCards = new int[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			CCards[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(CCards);

		int minBadScore = Integer.MAX_VALUE;
		for (int i = 0; i < A; i++) {
			int a = ACards[i];
			int b = binarySearch(BCards, a);
			int c1 = binarySearch(CCards, a);
			int c2 = binarySearch(CCards, b);

			int max = Math.max(Math.max(a, b), c1);
			int min = Math.min(Math.min(a, b), c1);
			minBadScore = Math.min(minBadScore, Math.abs(max - min));
			
			max = Math.max(Math.max(max, min), c2);
			min = Math.min(Math.min(a, b), c2);
			minBadScore = Math.min(minBadScore, Math.abs(max - min));
		}

		System.out.println(minBadScore);
		br.close();
	}

	static int binarySearch(int[] cards, int target) {
		int left = 0;
		int right = cards.length - 1;
		int result = cards[(left + right) / 2];
		while (left <= right) {
			int mid = (left + right) / 2;

			if (cards[mid] == target) {
				return target;
			} else if (cards[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}

			if (Math.abs(result - target) > Math.abs(cards[mid] - target)) {
				result = cards[mid];
			}
		}

		return result;
	}

}
