import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] c = br.readLine().toCharArray();
		int answer = 0;
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 'A' || c[i] == 'B' || c[i] == 'C') {
				answer += 3;
			} else if (c[i] == 'D' || c[i] == 'E' || c[i] == 'F') {
				answer += 4;
			} else if (c[i] == 'G' || c[i] == 'H' || c[i] == 'I') {
				answer += 5;
			} else if (c[i] == 'J' || c[i] == 'K' || c[i] == 'L') {
				answer += 6;
			} else if (c[i] == 'M' || c[i] == 'N' || c[i] == 'O') {
				answer += 7;
			} else if (c[i] == 'P' || c[i] == 'Q' || c[i] == 'R' || c[i] == 'S') {
				answer += 8;
			} else if (c[i] == 'T' || c[i] == 'U' || c[i] == 'V') {
				answer += 9;
			} else {
				answer += 10;
			}
		}
		System.out.println(answer);
		br.close();
	}
}
