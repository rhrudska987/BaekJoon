import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] fruits = new int[N];
		for (int i = 0; i < N; i++) {
			fruits[i] = Integer.parseInt(st.nextToken());
		}

		Map<Integer, Integer> map = new HashMap<>();
		map.put(fruits[0], 1);

		int max = 1;
		int left = 0;
		int right = 1;
		while (right < N) {
			if (map.containsKey(fruits[right])) {
				map.put(fruits[right], map.get(fruits[right]) + 1);
			} else {
				while (map.size() >= 2) {
					map.put(fruits[left], map.get(fruits[left]) - 1);
					if (map.get(fruits[left]) == 0) {
						map.remove(fruits[left]);
					}
					left++;
				}
				map.put(fruits[right], 1);
			}
			right++;
			max = Math.max(max, right - left);
		}

		System.out.println(max);
	}
}
