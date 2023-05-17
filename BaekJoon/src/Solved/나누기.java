package Solved;

import java.util.Scanner;

public class ³ª´©±â {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.next().split("");
		int F = sc.nextInt();
		str[str.length - 1] = "0";
		str[str.length - 2] = "0";
		int N = Integer.parseInt(String.join("", str));
		while(true) {
			if(N % F == 0)
				break;
			N++;
		}
		if(N%100 < 10)
			System.out.print("0" + N%10);
		else
			System.out.println(N%100);
	}
}
