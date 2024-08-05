import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] F;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String P = br.readLine();
		
		failureFunction(P);
		System.out.println(KMP(S, P));
		
		br.close();
	}
	
	static int KMP(String S, String P) {
		for (int i = 0, j = 0; i < S.length(); i++) {
			while (j > 0 && S.charAt(i) != P.charAt(j)) {
				j = F[j - 1];
			}
			
			if (S.charAt(i) == P.charAt(j)) {
				if (j == P.length() - 1) {
					return 1;
				}
				j++;
			}
		}
		
		return 0;
	}
	
	static void failureFunction(String P) {
		F = new int[P.length()];
		
		for (int i = 1, j = 0; i < P.length(); i++) {
			while (j > 0 && P.charAt(j) != P.charAt(i)) {
				j = F[j - 1];
			}
			
			if (P.charAt(j) == P.charAt(i)) {
				F[i] = ++j;
			}
		}
	}

}
