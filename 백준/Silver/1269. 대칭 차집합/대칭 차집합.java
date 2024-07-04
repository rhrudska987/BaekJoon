import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Set<Integer> A = new HashSet<>();
		Set<Integer> B = new HashSet<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B.add(Integer.parseInt(st.nextToken()));
		}

		int cnt = 0;
		Iterator<Integer> it = A.iterator();
		while (it.hasNext()) {
			if (!B.contains(it.next())) {
				cnt++;
			}
		}

		it = B.iterator();
		while (it.hasNext()) {
			if (!A.contains(it.next())) {
				cnt++;
			}
		}

		System.out.println(cnt);
		br.close();
	}

}
