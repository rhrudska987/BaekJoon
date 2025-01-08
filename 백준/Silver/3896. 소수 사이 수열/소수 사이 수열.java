import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	static int[] primeNumbers = new int[100000];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		findPrimeNumber();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int k = Integer.parseInt(br.readLine());
			binarySearch(k);
		}

		System.out.println(sb);
		br.close();
	}

	static void binarySearch(int k) {
		List<Integer> list = new ArrayList<>();

		int left = 0;
		int right = 99999;
		boolean isPrime = false;
		while (left <= right) {
			int mid = (right + left) / 2;
			list.add(primeNumbers[mid]);

			if (primeNumbers[mid] < k) {
				left = mid + 1;
			} else if (primeNumbers[mid] > k) {
				right = mid - 1;
			} else {
				isPrime = true;
				break;
			}
		}

		if (isPrime) {
			sb.append("0\n");
		} else {
			sb.append(findLen(list, k) + "\n");
		}
	}

	static int findLen(List<Integer> list, int k) {
		Collections.sort(list);
		for (int i = 1; i < list.size(); i++) {
			if (k < list.get(i)) {
				return list.get(i) - list.get(i - 1);
			}
		}
		return 0;
	}

	static void findPrimeNumber() {
		int idx = 0;
		for (int i = 2; i <= 1299709; i++) {
			boolean isPrime = true;

			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}

			if (isPrime) {
				primeNumbers[idx++] = i;
			}
		}
	}

}
