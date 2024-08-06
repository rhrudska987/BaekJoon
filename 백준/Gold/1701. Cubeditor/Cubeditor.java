import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();

		for (int i = 0; i < text.length(); i++) {
			String T = text.substring(i, text.length());
			KMP(T);
		}

		System.out.println(max);
		br.close();
	}

	static void KMP(String text) {
		int[] F = new int[text.length()];
		for (int i = 1, j = 0; i < text.length(); i++) {
			while (j > 0 && text.charAt(i) != text.charAt(j)) {
				j = F[j - 1];
			}

			if (text.charAt(j) == text.charAt(i)) {
				F[i] = ++j;
				max = Math.max(max, F[i]);
			}
		}
	}

}
