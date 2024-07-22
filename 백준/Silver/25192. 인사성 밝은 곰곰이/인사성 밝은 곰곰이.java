import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		Set<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			int beforeSize = set.size();
			String userName = br.readLine();
			
			if (userName.equals("ENTER")) {
				set.clear();
				continue;
			}
			
			set.add(userName);
			if (beforeSize != set.size()) {
				ans++;
			}
		}
		
		System.out.println(ans);
		br.close();
	}
}
