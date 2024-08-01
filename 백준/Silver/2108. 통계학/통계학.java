import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[8001];
		int[] num = new int[N];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
			arr[num[i] + 4000]++;
			sum += num[i];
		}
		
		int max = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i <= 8000; i++) {
			max = Math.max(max, arr[i]);
		}
		
		for (int i = 0; i <= 8000; i++) {
			if (arr[i] == max) {
				list.add(i - 4000);
			}
		}
		
		Arrays.sort(num);
		
		if (sum < 0) {
			System.out.println(Math.round(Math.abs(sum) / (double) N) * -1);
		} else {
			System.out.println(Math.round(Math.abs(sum / (double) N)));
		}
		System.out.println(num[N / 2]);
		if (list.size() > 1) {
			System.out.println(list.get(1));
		} else {
			System.out.println(list.get(0));
		}
		System.out.println(num[N - 1] - num[0]);
		
		br.close();
	}

}
