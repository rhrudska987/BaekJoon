import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = {"0", "1", "2", "3", 
						"4", "5", "6", "7", 
						"8", "9", "A", "B", 
						"C", "D", "E", "F", 
						"G", "H", "I", "J", 
						"K", "L", "M", "N", 
						"O", "P", "Q", "R", 
						"S", "T", "U", "V", 
						"W", "X", "Y", "Z"};

		String[] s = sc.next().split("");
		int N = sc.nextInt();
		int tenNum = 0;
		for (int i = 0; i < s.length; i++) {
			int num = 1;
			for (int j = 0; j < s.length - 1 - i; j++) {
				num *= N;
			}
			for (int j = 0; j < 36; j++) {
				if (s[i].equals(str[j])) {
					num *= j;
					break;
				}
			}
			tenNum += num;
		}

		System.out.println(tenNum);
		sc.close();
	}
}
