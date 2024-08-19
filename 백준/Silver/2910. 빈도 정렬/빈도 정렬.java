import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		List<Integer> originList = new ArrayList<>();
		List<Integer> sortedList = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			originList.add(num);
			sortedList.add(num);
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		Collections.sort(sortedList, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (map.get(o1) != map.get(o2)) {
					return map.get(o2) - map.get(o1);
				}
				return originList.indexOf(o1) - originList.indexOf(o2);
			}
		});
		
		
		StringBuilder sb = new StringBuilder();
		for (int key : sortedList) {
			sb.append(key + " ");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
	
}
