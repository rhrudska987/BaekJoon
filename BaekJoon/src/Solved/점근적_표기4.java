package Solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 점근적_표기4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		double a2 = Integer.parseInt(st.nextToken());
		double a1 = Integer.parseInt(st.nextToken());
		double a0 = Integer.parseInt(st.nextToken());
		
		double c = Integer.parseInt(br.readLine());
		double n0 = Integer.parseInt(br.readLine());
		
		double fn = a2*n0*n0 + a1*n0 + a0;
		double gn = c*n0*n0;
		if(a2==c) {
			if(a1 == 0) {
				if(a0 <= 0 && fn <= gn) {
					bw.write("1");
				}
				else
					bw.write("0");
			}
			else if((a1/(2*a2)) >= 0 && fn <= gn) {
				bw.write("1");
			}
			else
				bw.write("0");
		}
		else if(a2 < c && fn <= gn) {
			bw.write("1");
		}
		else
			bw.write("0");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
