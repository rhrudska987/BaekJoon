import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int[][] video;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		video = new int[N][N];
		for (int i = 0; i < N; i++) {
			video[i] = Stream.of(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}
		
		if (N == 1) {
			System.out.println(video[0][0]);
			return;
		}
		
		divideConquer(0, 0, N);

		System.out.println(sb.toString());
		br.close();
	}

	static String divideConquer(int y, int x, int size) {
		if (size == 1) {
			return String.valueOf(video[y][x]);
		}

		String leftUp = divideConquer(y, x, size / 2);
		String rightUp = divideConquer(y, x + size / 2, size / 2);
		String leftDown = divideConquer(y + size / 2, x, size / 2);
		String rightDown = divideConquer(y + size / 2, x + size / 2, size / 2);

		if (size == N) {
			if (leftUp.equals(rightUp) && rightUp.equals(leftDown) && leftDown.equals(rightDown)
				&& leftUp.length() == 1) {
				sb.append(leftUp);
			} else {
				sb.append("(").append(leftUp).append(rightUp).append(leftDown).append(rightDown).append(")");
			}
		}

		if (leftUp.equals(rightUp) && rightUp.equals(leftDown) && leftDown.equals(rightDown) && leftUp.length() == 1) {
			return leftUp;
		} else {
			return "(".concat(leftUp).concat(rightUp).concat(leftDown).concat(rightDown).concat(")");
		}
	}

}
