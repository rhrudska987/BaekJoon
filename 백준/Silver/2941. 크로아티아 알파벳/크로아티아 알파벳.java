import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String[] str_arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

		int ans = 0;
		while (s.length() > 0) {
			boolean croatia = false;
			for (int i = 0; i < 8; i++) {
				if (s.startsWith(str_arr[i])) {
					croatia = true;
					s = s.substring(str_arr[i].length());
					break;
				}
			}

			if (!croatia) {
				s = s.substring(1);
			}
			ans++;
		}

		System.out.println(ans);
		br.close();
	}
}
