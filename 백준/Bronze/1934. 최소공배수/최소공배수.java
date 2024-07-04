import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		
		while (T-- > 0) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			int idx = 1;
			if (A > B) {
				while (A * idx % B != 0) {
					idx++;
				}
				sb.append(A * idx).append("\n");
			} else {
				while (B * idx % A != 0) {
					idx++;
				}
				sb.append(B * idx).append("\n");
			}
		}
		
		System.out.println(sb.toString());
		sc.close();
	}

}
