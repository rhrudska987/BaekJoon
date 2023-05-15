package Solved;

import java.util.Scanner;

public class 직사각형에서_탈출 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		int min = 1000;
		if(x < min)
			min = x;
		if(Math.abs(w - x) < min)
			min = Math.abs(w - x);
		if(y < min)
			min = y;
		if(Math.abs(h-y) < min)
			min = Math.abs(h-y);
		System.out.println(min);
	}
}
