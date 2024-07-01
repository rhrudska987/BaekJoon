import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		double[] score = new double[N];
		double maxScore = 0;
		for (int i = 0; i < N; i++) {
			score[i] = sc.nextDouble();
			maxScore = Math.max(maxScore, score[i]);
		}

		for (int i = 0; i < N; i++) {
			score[i] = score[i] / maxScore * 100;
		}
		
		double sum = 0;
		for (int k = 0; k < N; k++) {
			sum += score[k];
		}
		
		System.out.println(sum / N);
		sc.close();
	}

}
