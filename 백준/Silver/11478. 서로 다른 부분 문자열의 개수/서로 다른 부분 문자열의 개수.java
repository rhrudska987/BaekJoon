import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();

		Set<String> set = new HashSet<>();
		for (int i = 1; i <= S.length(); i++) {
			for (int j = 0; j < S.length(); j++) {
				if (j + i > S.length()) {
					break;
				}
				set.add(S.substring(j, j + i));
			}
		}

		System.out.println(set.size());
		br.close();
	}

}
