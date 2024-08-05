import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int[] F;
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String T = br.readLine();
		String P = br.readLine();

		failureFunction(P);
		KMP(T, P);

		StringBuilder sb = new StringBuilder();
		sb.append(list.size()).append("\n");
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}

		System.out.println(sb.toString());
		br.close();
	}

	static void KMP(String text, String pattern) {
		for (int i = 0, j = 0; i < text.length(); i++) {
			while (j > 0 && pattern.charAt(j) != text.charAt(i)) {
				j = F[j - 1];
			}

			if (pattern.charAt(j) == text.charAt(i)) {
				if (j == pattern.length() - 1) {
					list.add(i - j + 1);
					j = F[j];
				} else {
					j++;
				}
			}
		}

	}

	static void failureFunction(String pattern) {
		F = new int[pattern.length()];

		for (int i = 1, j = 0; i < pattern.length(); i++) {
			while (j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
				j = F[j - 1];
			}

			if (pattern.charAt(j) == pattern.charAt(i)) {
				F[i] = ++j;
			}
		}

	}

}
