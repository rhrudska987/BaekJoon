import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());

		Set<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String command = st.nextToken();

			if (command.equals("enter")) {
				set.add(name);
			} else {
				set.remove(name);
			}
		}

		String[] ans = new String[set.size()];
		Iterator<String> i = set.iterator();
		int idx = 0;
		while (i.hasNext()) {
			ans[idx] = i.next();
			idx++;
		}

		Arrays.sort(ans, Collections.reverseOrder());

		for (int j = 0; j < ans.length; j++) {
			System.out.println(ans[j]);
		}

		br.close();
	}

}
