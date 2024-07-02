import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int[] xArr = new int[1001];
		int[] yArr = new int[1001];
		
		for (int i = 0; i <3; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			xArr[x]++;
			yArr[y]++;
		}
		
		for (int i = 0; i < 1001; i++) {
			if (xArr[i] == 1) {
				System.out.print(i + " ");
				break;
			}
		}
		
		for (int i = 0; i < 1001; i++) {
			if (yArr[i] == 1) {
				System.out.print(i);
				break;
			}
		}
		
		br.close();
	}
}
