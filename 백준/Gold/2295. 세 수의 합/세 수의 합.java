import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Set<Integer> set = new HashSet<>();
		int[] U = new int[N];
		for (int i = 0; i < N; i++) {
			U[i] = Integer.parseInt(br.readLine());
			set.add(U[i]);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				set.add(U[i] + U[j]);
			}
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (set.contains(U[j] - U[i])) {
					max = Math.max(max, U[j]);
				}
			}
		}

		System.out.println(max);
		br.close();
	}

}
