import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		double totalScore = 0;
		int totalCredit = 0;
		for (int i = 0; i < 20; i++) {
			st = new StringTokenizer(br.readLine());
			String subjet = st.nextToken();
			double credit = Double.parseDouble(st.nextToken());
			String grade = st.nextToken();
			
			if (grade.equals("P")) {
				continue;
			}
			
			totalCredit += credit;
			
			if (grade.equals("A+")) {
				totalScore += credit * 4.5;
			} else if (grade.equals("A0")) {
				totalScore += credit * 4.0;
			} else if (grade.equals("B+")) {
				totalScore += credit * 3.5;
			} else if (grade.equals("B0")) {
				totalScore += credit * 3.0;
			} else if (grade.equals("C+")) {
				totalScore += credit * 2.5;
			} else if (grade.equals("C0")) {
				totalScore += credit * 2.0;
			} else if (grade.equals("D+")) {
				totalScore += credit * 1.5;
			} else if (grade.equals("D0")) {
				totalScore += credit * 1.0;
			} else {
				totalScore += credit * 0;
			}
		}

		System.out.println(totalScore / totalCredit);
		br.close();
	}
}
