import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String T = br.readLine();
		String P = br.readLine();
		int[] table = new int[P.length()];

		for (int i = 1, j = 0; i < P.length(); i++) {
			while (j > 0 && P.charAt(i) != P.charAt(j)) {
				j = table[j - 1];
			}

			if (P.charAt(i) == P.charAt(j)) {
				table[i] = ++j;
			}
		}

		List<Integer> startPoint = new ArrayList<>();

		for (int i = 0, j = 0; i < T.length(); i++) {
			while (j > 0 && T.charAt(i) != P.charAt(j)) {
				j = table[j - 1];
			}

			if (T.charAt(i) == P.charAt(j)) {
				if (j == P.length() - 1) {
					startPoint.add(i - j + 1);
					j = table[j];
				} else {
					++j;
				}
			}
		}

		sb.append(startPoint.size() + "\n");
		for (int i = 0; i < startPoint.size(); i++) {
			sb.append(startPoint.get(i) + " ");
		}

		System.out.println(sb.toString());
		br.close();
	}
}
