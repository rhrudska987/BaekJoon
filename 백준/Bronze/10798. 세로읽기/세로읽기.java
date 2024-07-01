import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		List<ArrayList<String>> list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < 5; i++) {
			String[] s = sc.nextLine().split("");
			for (int j = 0; j < s.length; j++) {
				list.get(i).add(s[j]);
			}
		}

		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				if (list.get(j).size() > i) {
					sb.append(list.get(j).get(i));
				}
			}
		}

		System.out.println(sb.toString());
		sc.close();
	}
}
