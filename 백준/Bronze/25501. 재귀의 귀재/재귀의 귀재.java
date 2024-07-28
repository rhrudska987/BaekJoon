import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {	
	
	static int cnt = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			cnt = 0;
			sb.append(isPalindrome(br.readLine().toCharArray())).append(" ").append(cnt).append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
	
	static int recursion(char[] s, int l, int r) {
		cnt++;
		if (l >= r) return 1;
		else if(s[l] != s[r]) return 0;
		else return recursion(s, l + 1, r - 1);
	}
	
	static int isPalindrome(char[] s) {
		return recursion(s, 0, s.length - 1);
	}
	
}
