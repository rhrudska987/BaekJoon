import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[][] visited = new boolean[100][100];

		int N = sc.nextInt();
		int sum = 0;
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					if (!visited[k][j]) {
						visited[k][j] = true;
						sum += 1;
					}
				}
			}
		}
		
		System.out.println(sum);
		sc.close();
	}
}
