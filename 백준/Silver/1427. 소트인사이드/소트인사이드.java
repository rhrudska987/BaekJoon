import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = br.readLine().split("");
		Arrays.sort(s, Collections.reverseOrder());
		for (int i = 0; i < s.length; i++) {
			sb.append(s[i]);
		}
		System.out.println(sb.toString());
		br.close();
	}

}
