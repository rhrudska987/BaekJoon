import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String word = br.readLine();
		while (!word.equals("end")) {
			boolean includeVowel = condition1(word);
			boolean consecutiveThree = condition2(word);
			boolean sameSpelling = condition3(word);

			if (includeVowel && consecutiveThree && sameSpelling) {
				sb.append("<" + word + "> is acceptable.\n");
			} else {
				sb.append("<" + word + "> is not acceptable.\n");
			}
			
			word = br.readLine();
		}

		System.out.println(sb.toString());
		br.close();
	}

	static boolean condition1(String word) {
		String[] str = word.split("");

		for (int i = 0; i < str.length; i++) {
			if (str[i].equals("a") || str[i].equals("e") || str[i].equals("i") || str[i].equals("o")
				|| str[i].equals("u")) {
				return true;
			}
		}

		return false;
	}

	static boolean condition2(String word) {
		String[] str = word.split("");

		int cnt1 = 0;
		int cnt2 = 0;
		for (int i = 0; i < str.length; i++) {
			if (str[i].equals("a") || str[i].equals("e") || str[i].equals("i") || str[i].equals("o")
				|| str[i].equals("u")) {
				cnt1++;
				cnt2 = 0;
			} else {
				cnt1 = 0;
				cnt2++;
			}
			if (cnt1 == 3 || cnt2 == 3) {
				return false;
			}
		}

		return true;
	}

	static boolean condition3(String word) {
		String[] str = word.split("");

		for (int i = 0; i < str.length - 1; i++) {
			if (str[i].equals(str[i + 1]) && !str[i].equals("e") && !str[i].equals("o")) {
				return false;
			}
		}

		return true;
	}

}
