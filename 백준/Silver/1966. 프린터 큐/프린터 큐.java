import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			LinkedList<Document> list = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				int priority = sc.nextInt();
				list.add(new Document(i, priority));
			}

			int cnt = 0;
			while (!list.isEmpty()) {
				Document doc = list.poll();
				boolean isMaxPriority = true;

				for (Document d : list) {
					if (d.priority > doc.priority) {
						isMaxPriority = false;
						break;
					}
				}

				if (isMaxPriority) {
					cnt++;
					if (doc.docNumber == M) {
						break;
					}
				} else {
					list.add(doc);
				}
			}

			sb.append(cnt).append("\n");
		}

		System.out.println(sb);
		sc.close();
	}

	private static class Document {
		int docNumber;
		int priority;

		public Document(int docNumber, int priority) {
			this.docNumber = docNumber;
			this.priority = priority;
		}
	}

}
