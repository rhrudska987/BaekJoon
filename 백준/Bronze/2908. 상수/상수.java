import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		char[] c1 = st.nextToken().toCharArray();
		char[] c2 = st.nextToken().toCharArray();
		int num1 = 0;
		int num2 = 0;
		for (int i = 2; i >= 0; i--) {
			num1 += (c1[i] - '0') * Math.pow(10, i);
			num2 += (c2[i] - '0') * Math.pow(10, i);
		}
		System.out.println(Math.max(num1, num2));
		br.close();
	}
}
