import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] population;
	static int totalPopulation = 0;
	static int min = Integer.MAX_VALUE;
	static boolean[][] v;
	static boolean[] v2;
	static List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		population = new int[N + 1];
		v = new boolean[N + 1][N + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
			totalPopulation += population[i];
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < M; j++) {
				int neighbor = Integer.parseInt(st.nextToken());
				v[i + 1][neighbor] = true;
				v[neighbor][i + 1] = true;
			}
		}
		
		list.add(1);
		for (int i = 1; i < N; i++) {
			v2 = new boolean[N + 1];
			permutation(1, i, 2);
		}
		
		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
		br.close();
		
	}
	
	
	static void permutation(int now, int cnt, int idx) {
		if (now == cnt) {
			List<Integer> list2 = new ArrayList<>();
			for (int i = 1; i <= N; i++) {
				if (!list.contains((Integer) i)) {
					list2.add(i);
				}
			}
			
			if(checkConnect(list) && checkConnect(list2)) {
				int populationSum = 0;
				for (int i = 0; i < list.size(); i++) {
					populationSum += population[list.get(i)];
				}
				min = Math.min(min, Math.abs(totalPopulation - 2*populationSum));
			}
			return;
		}
		
		for (int i = idx; i <= N; i++) {
			if (!v2[i]) {
				v2[i] = true;
				list.add(i);
				permutation(now+1, cnt, i + 1);
				list.remove(list.size() - 1);
				v2[i] = false;
			}
		}
	}
	
	static boolean checkConnect(List<Integer> list) {
		boolean connected = true;
		List<Integer> list_clone = new ArrayList<>(list);
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.add(list_clone.get(0));
		list_clone.remove((Integer) list_clone.get(0));
		while (!q.isEmpty()) {
			int n = q.poll();
			for (int i = 1; i <= N; i++) {
				if (i == n) {
					continue;
				}
				
				if (v[n][i] == true && list_clone.contains((Integer) i)) {
					q.add(i);
					list_clone.remove((Integer) i);
				}
			}
		}
		
		if (list_clone.size() != 0) {
			connected = false;
		}
		
		return connected;
	}
	
}
