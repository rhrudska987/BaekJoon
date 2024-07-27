import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] score = new int[N + 1];
		int[] player = new int[N];

		int maxCardNum = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			player[i] = Integer.parseInt(st.nextToken());
			maxCardNum = Math.max(maxCardNum, player[i]);
		}

		int[] cardArr = new int[maxCardNum + 1];
		for (int i = 0; i < N; i++) {
			cardArr[player[i]] = i + 1;
		}

		for (int m : player) {
			for (int i = m * 2; i <= maxCardNum; i += m) {
				if (cardArr[i] != 0) {
					score[cardArr[i]]--;
					score[cardArr[m]]++;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(score[i]).append(" ");
		}

		System.out.println(sb.toString());
		br.close();
	}

}
