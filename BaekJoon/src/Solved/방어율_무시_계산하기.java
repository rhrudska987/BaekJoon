package Solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 방어율_무시_계산하기 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		double power = 0;
		while(st.hasMoreTokens()) {
			power = Math.abs(1 - (1 - power/100) * (1 - Double.parseDouble(st.nextToken())/100));
			power *= 100;
			System.out.println(Math.round(power*1000000)/1000000.0);
		}
		br.close();
	}
}
