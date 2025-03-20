import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();

		int i = 2;
		int cnt = 1;
		while (i < K) {
			i += Math.pow(2, ++cnt);
		}

		int[] arr = new int[cnt];
		i -= Math.pow(2, cnt);
		K -= i;
		K--;

		StringBuilder sb = new StringBuilder();
		for (int j = cnt - 1; j >= 0; j--) {
			if (K == 0 || K % 2 == 0) {
				arr[j] = 4;
			} else {
				arr[j] = 7;
			}
			K /= 2;
		}

		for (int j = 0; j < cnt; j++) {
			sb.append(arr[j]);
		}
		System.out.println(sb);
		sc.close();
	}

}
