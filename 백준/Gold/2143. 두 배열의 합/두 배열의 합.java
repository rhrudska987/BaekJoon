import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int T, n, m;
	static int[] A;
	static int[] B;
	static List<Long> subA = new ArrayList<>();
	static List<Long> subB = new ArrayList<>();
	static long answer = 0;

	public static void main(String[] args) throws Exception {
		readInput();
		createSubArray();
		binarySearch();
		printAnswer();
	}

	private static void readInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		n = Integer.parseInt(br.readLine());
		A = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		m = Integer.parseInt(br.readLine());
		B = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		br.close();
	}

	private static void createSubArray() {
		for (int i = 0; i < n; i++) {
			long sum = A[i];
			subA.add(sum);
			for (int j = i + 1; j < n; j++) {
				sum += A[j];
				subA.add(sum);
			}
		}

		for (int i = 0; i < m; i++) {
			long sum = B[i];
			subB.add(sum);
			for (int j = i + 1; j < m; j++) {
				sum += B[j];
				subB.add(sum);
			}
		}

		Collections.sort(subA);
		Collections.sort(subB, Collections.reverseOrder());
	}

	private static void binarySearch() {
		int curAIdx = 0;
		int curBIdx = 0;
		while (curAIdx < subA.size() && curBIdx < subB.size()) {
			long sum = subA.get(curAIdx) + subB.get(curBIdx);

			if (sum > T) {
				curBIdx++;
			} else if (sum < T) {
				curAIdx++;
			} else {
				long ACount = 0;
				long BCount = 0;
				long currentA = subA.get(curAIdx);
				long currentB = subB.get(curBIdx);

				while (curAIdx < subA.size() && subA.get(curAIdx) == currentA) {
					ACount++;
					curAIdx++;
				}
				while (curBIdx < subB.size() && subB.get(curBIdx) == currentB) {
					BCount++;
					curBIdx++;
				}

				answer += ACount * BCount;
			}
		}
	}

	private static void printAnswer() {
		System.out.println(answer);
	}

}
