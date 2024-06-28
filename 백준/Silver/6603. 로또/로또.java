import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[] lotto = new int[6];
	static int[] S;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String[] str = br.readLine().split(" ");

			if (str.length == 1 && str[0].equals("0")) {
				break;
			}

			S = new int[Integer.parseInt(str[0])];
			for (int i = 1; i < str.length; i++) {
				S[i - 1] = Integer.parseInt(str[i]);
			}

			Arrays.sort(S);

			backTracking(0, 0);
			sb.append("\n");
		}

		System.out.println(sb.toString());
		br.close();
	}

	static void backTracking(int lottoIdx, int SIdx) {
		if (lottoIdx == 6) {
			for (int i = 0; i < 6; i++) {
				sb.append(lotto[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = SIdx; i < S.length; i++) {
			lotto[lottoIdx] = S[i];
			backTracking(lottoIdx + 1, i + 1);
		}
	}
}
