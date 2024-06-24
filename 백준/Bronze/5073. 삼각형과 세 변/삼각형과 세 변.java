import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			if (a == 0 && b == 0 && c == 0) {
				break;
			}
			
			int[] tri = {a, b, c};
			Arrays.sort(tri);
			
			if (tri[0] + tri[1] <= tri[2]) {
				sb.append("Invalid\n");
			} else if (a == b && b == c) {
				sb.append("Equilateral\n");
			} else if (a == b || b == c || a == c) {
				sb.append("Isosceles\n");
			} else {
				sb.append("Scalene\n");
			}
		}
		
		System.out.println(sb.toString());
		sc.close();
	}
}
