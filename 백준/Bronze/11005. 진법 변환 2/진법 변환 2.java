import java.util.ArrayList;
import java.util.List;
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
		
		int N = sc.nextInt();
		int B = sc.nextInt();
		
		List<String> list = new ArrayList<>();
		while (N != 0) {
			list.add(str[N % B]);
			N /= B;
		}

		for (int i = list.size() - 1; i >= 0; i--) {
			System.out.print(list.get(i));
		}
		sc.close();
	}
}
