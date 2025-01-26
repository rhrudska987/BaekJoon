import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		int testCases = Integer.parseInt(br.readLine());
		while (testCases-- > 0) {
			PriorityQueue<Long> fileSizes = new PriorityQueue<>();
			readInput(fileSizes);
			long minCost = calcMinCost(fileSizes);
			appendAnswer(minCost);
		}

		System.out.println(sb);
		br.close();
	}

	private static void readInput(PriorityQueue<Long> fileSizes) throws IOException {
		int numberOfFiles = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < numberOfFiles; i++) {
			fileSizes.add(Long.parseLong(st.nextToken()));
		}
	}

	private static long calcMinCost(PriorityQueue<Long> fileSizes) {
		long totalCost = 0;
		while (fileSizes.size() >= 2) {
			long firstFile = fileSizes.poll();
			long secondFile = fileSizes.poll();
			totalCost += firstFile + secondFile;
			fileSizes.add(firstFile + secondFile);
		}

		return totalCost;
	}

	private static void appendAnswer(long minCost) {
		sb.append(minCost + "\n");
	}

}
