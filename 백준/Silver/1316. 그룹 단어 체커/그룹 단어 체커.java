import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int ans = 0;
		while (T-- > 0) {
			Set<String> set = new HashSet<>();
			String[] str = br.readLine().split("");
			int idx = 0;
			boolean isGroupWord = true;
			while (idx < str.length) {
				if (!set.contains(str[idx])) {
					set.add(str[idx]);
					String s = str[idx];
					idx++;
					while (idx < str.length) {
						if (s.equals(str[idx])) {
							idx++;
						} else {
							break;
						}
					}
				} else {
					isGroupWord = false;
					break;
				}
			}

			if (isGroupWord) {
				ans++;
			}
		}

		System.out.println(ans);
		br.close();
	}
}
