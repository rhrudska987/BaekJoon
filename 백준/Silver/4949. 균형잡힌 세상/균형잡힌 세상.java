import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			String[] line = sc.nextLine().split("");
			if (line.length == 1 && line[0].equals(".")) {
				break;
			}
			
			Stack<String> q = new Stack<>();
			
			boolean balance = true;
			for (int i = 0; i < line.length; i++) {
				if (line[i].equals("(")) {
					q.add("(");
				} else if (line[i].equals("[")) {
					q.add("[");
				} else if (line[i].equals(")")) {
					if (q.size() == 0 || q.peek().equals("[")) {
						sb.append("no").append("\n");
						balance = false;
						break;
					} else {
						q.pop();
					}
				} else if (line[i].equals("]")) {
					if (q.size() == 0 || q.peek().equals("(")) {
						sb.append("no").append("\n");
						balance = false;
						break;
					} else {
						q.pop();
					}
				}
			}
			
			if (balance && (q.size() != 0)) {
				sb.append("no").append("\n");
				balance = false;
			}
			
			if (balance) {
				sb.append("yes").append("\n");
			}
		}

		System.out.println(sb.toString());
		sc.close();
	}

}
