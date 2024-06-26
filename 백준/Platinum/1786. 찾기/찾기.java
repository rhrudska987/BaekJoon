import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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

		int cnt = 0;
		for (int i = 0, j = 0; i < T.length(); i++) {
			while (j > 0 && T.charAt(i) != P.charAt(j)) {
				j = table[j - 1];
			}

			if (T.charAt(i) == P.charAt(j)) {
				if (j == P.length() - 1) {
					cnt++;
					startPoint.add(i - j + 1);
					j = table[j];
				} else {
					++j;
				}
			}
		}

		System.out.println(cnt);
		for (int i = 0; i < startPoint.size(); i++) {
			System.out.print(startPoint.get(i) + " ");
		}
		System.out.println();

		br.close();
	}
}
