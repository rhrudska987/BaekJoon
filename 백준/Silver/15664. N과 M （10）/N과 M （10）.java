import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] selectedNumbers;
	static List<Integer> inputNumberList;
	static Set<String> set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		inputNumberList = new ArrayList<>();
		set = new HashSet<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			inputNumberList.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(inputNumberList);

		selectedNumbers = new int[M];
		for (int i = 0; i < inputNumberList.size(); i++) {
			selectedNumbers[0] = inputNumberList.get(i);
			backTracking(i, 1);
		}

		br.close();
	}

	private static void backTracking(int startIdx, int cnt) {
		if (cnt == M) {
			printSequence();
			return;
		}

		for (int i = startIdx + 1; i < N; i++) {
			if (inputNumberList.get(i) < selectedNumbers[cnt - 1]) {
				continue;
			}

			selectedNumbers[cnt] = inputNumberList.get(i);
			backTracking(i, cnt + 1);
		}

	}

	private static void printSequence() {
		StringBuilder sequence = new StringBuilder();
		for (int number : selectedNumbers) {
			sequence.append(number).append(" ");
		}
		
		if (set.add(sequence.toString())) {
			System.out.println(sequence.toString().trim());
		}
	}

}
