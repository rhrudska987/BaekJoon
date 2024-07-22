import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] fact = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(fact[Integer.parseInt(br.readLine())]);
		br.close();
	}
}
