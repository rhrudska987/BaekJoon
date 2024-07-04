import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<String, Integer> map = new HashMap<>();
		List<String> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			map.put(name, i + 1);
			list.add(name);
		}

		for (int i = 0; i < M; i++) {
			String input = br.readLine();
			if (map.containsKey(input)) {
				sb.append(map.get(input) + "\n");
			} else {
				sb.append(list.get(Integer.parseInt(input) - 1) + "\n");
			}
		}
		System.out.println(sb.toString());

		br.close();
	}

}
