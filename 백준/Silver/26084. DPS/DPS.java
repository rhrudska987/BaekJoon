import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	static final int TEAM_NAME_SIZE = 3;

	static int N;
	static long answer = 1;
	static Map<Character, Integer> teamNameMap = new HashMap<>();
	static Map<Character, Integer> handleNameMap = new HashMap<>();

	public static void main(String[] args) throws Exception {
		readInput();
		calculateCombinations();
		printAnswer();
	}

	private static void printAnswer() {
		System.out.println(answer);
	}

	private static void calculateCombinations() {
		for (char c : teamNameMap.keySet()) {
			if (!handleNameMap.containsKey(c)) {
				answer = 0;
				break;
			}

			long combinations = 1;
			int availableCnt = handleNameMap.get(c);
			int requiredCnt = teamNameMap.get(c);

			for (int i = availableCnt; i > availableCnt - requiredCnt; i--) {
				combinations *= i;
			}

			for (int i = requiredCnt; i > 0; i--) {
				combinations /= i;
			}

			answer *= combinations;
		}
	}

	private static void readInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] teamNameArr = br.readLine().toCharArray();

		for (int i = 0; i < teamNameArr.length; i++) {
			teamNameMap.put(teamNameArr[i], teamNameMap.getOrDefault(teamNameArr[i], 0) + 1);
		}

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			if (teamNameMap.containsKey(name.charAt(0))) {
				handleNameMap.put(name.charAt(0), handleNameMap.getOrDefault(name.charAt(0), 0) + 1);
			}
		}
		br.close();
	}

}
