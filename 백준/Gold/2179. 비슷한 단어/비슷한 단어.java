import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static String[] words;
	static String a = "";
	static String b = "";
	static int maxLength = 0;

	public static void main(String[] args) throws IOException {
		readInput();
		findAnswer();
		printAnswer();
	}

	private static void readInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		words = new String[N];
		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();
		}

		br.close();
	}

	private static void findAnswer() {
		for (int i = 0; i < N - 1; i++) {
			String curWord = words[i];

			if (isSmallerThanMaxLength(curWord)) {
				continue;
			}

			for (int j = i + 1; j < N; j++) {
				String nextWord = words[j];

				if (isSmallerThanMaxLength(nextWord)) {
					continue;
				}

				int sameHeadSpellLength = calcSameHeadSpell(curWord, nextWord);

				if (isBiggerThanMaxLength(sameHeadSpellLength)) {
					maxLength = sameHeadSpellLength;
					a = curWord;
					b = nextWord;
				}
			}
		}
	}

	private static boolean isSmallerThanMaxLength(String word) {
		return word.length() < maxLength;
	}

	private static boolean isBiggerThanMaxLength(int sameHeadSpellLength) {
		return sameHeadSpellLength > maxLength;
	}

	private static int calcSameHeadSpell(String a, String b) {
		char[] firstWord = a.toCharArray();
		char[] secondWord = b.toCharArray();

		int idx = 0;
		while (idx < firstWord.length && idx < secondWord.length) {
			if (firstWord[idx] != secondWord[idx]) {
				break;
			}

			idx++;
		}

		return idx;
	}

	private static void printAnswer() {
		System.out.println(a);
		System.out.println(b);
	}

}
