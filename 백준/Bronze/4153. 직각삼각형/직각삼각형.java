import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int a, b, c;
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			if (a == 0 && b == 0 && c == 0) {
				break;
			}

			boolean isRightTriangle = false;
			if (a * a == b * b + c * c || b * b == c * c + a * a || c * c == a * a + b * b) {
				isRightTriangle = true;
			}
			
			if (isRightTriangle) {
				sb.append("right").append("\n");
			} else {
				sb.append("wrong").append("\n");
			}
		}
		
		System.out.println(sb);
		br.close();
	}

}
