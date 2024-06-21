import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static char[] words;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			words = br.readLine().toCharArray();
			nextPermutation();
			sb.append(String.valueOf(words) + "\n");
		}

		System.out.println(sb.toString());
		br.close();
	}

	static void nextPermutation() {
		int i = words.length - 1;
		while (i > 0 && words[i - 1] >= words[i]) {
			i--;
		}

		if (i == 0) {
			return;
		}

		int j = words.length - 1;
		while (words[i - 1] >= words[j]) {
			j--;
		}

		swap(i - 1, j);

		int k = words.length - 1;
		while (i < k) {
			swap(i, k);
			i++;
			k--;
		}
	}

	static void swap(int i, int j) {
		char tmp = words[i];
		words[i] = words[j];
		words[j] = tmp;
	}

}
