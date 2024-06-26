import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static List<Integer> S = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();

			if (command.equals("add")) {
				add(Integer.parseInt(st.nextToken()));
			} else if (command.equals("check")) {
				check(Integer.parseInt(st.nextToken()));
			} else if (command.equals("remove")) {
				remove(Integer.parseInt(st.nextToken()));
			} else if (command.equals("toggle")) {
				toggle(Integer.parseInt(st.nextToken()));
			} else if (command.equals("all")) {
				all();
			} else {
				empty();
			}
		}

		System.out.println(sb.toString());
		br.close();
	}

	static void add(int x) {
		if (!S.contains(x)) {
			S.add(x);
		}
	}

	static void check(int x) {
		if (S.contains(x)) {
			sb.append("1\n");
		} else {
			sb.append("0\n");
		}
	}

	static void remove(int x) {
		if (S.contains(x)) {
			S.remove((Integer)x);
		}
	}

	static void toggle(int x) {
		if (S.contains(x)) {
			remove(x);
		} else {
			add(x);
		}
	}

	static void all() {
		empty();
		for (int i = 1; i <= 20; i++) {
			S.add(i);
		}
	}

	static void empty() {
		while (!S.isEmpty()) {
			S.remove(0);
		}
	}
}
