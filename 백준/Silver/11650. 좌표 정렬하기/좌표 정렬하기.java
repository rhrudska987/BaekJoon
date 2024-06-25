import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[][] point_arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			point_arr[i][0] = Integer.parseInt(st.nextToken());
			point_arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(point_arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		});

		for (int[] i : point_arr) {
			for (int j : i) {
				sb.append(j + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
		br.close();
	}
}
