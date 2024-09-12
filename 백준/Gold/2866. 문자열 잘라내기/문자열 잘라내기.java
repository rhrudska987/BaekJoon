import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		String[][] table = new String[R][C];
		for (int i = 0; i < R; i++) {
			table[i] = br.readLine().split("");
		}

		int start = 0;
		int end = R - 1;
		while (start < end) {
			int mid = (start + end) / 2;

			Set<String> set = new HashSet<>();
			boolean duplicate = false;
			for (int j = 0; j < C; j++) {
				String s = "";
				for (int i = mid + 1; i < R; i++) {
					s = s.concat(table[i][j]);
				}

				if (set.contains(s)) {
					duplicate = true;
					break;
				}
				set.add(s);
			}

			if (duplicate) {
				end = mid;
			} else {
				start = mid + 1;
			}

		}

		System.out.println(start);
		br.close();
	}

}
