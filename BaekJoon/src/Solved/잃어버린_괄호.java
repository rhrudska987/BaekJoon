package Solved;

import java.util.Scanner;

public class �Ҿ����_��ȣ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String sub[] = sc.nextLine().split("-");
		
		int answer = 0;
		boolean check_first = true;
		for(int i=0; i<sub.length; i++) {
			int sum = 0;
			
			String add[] = sub[i].split("\\+");
			
			for(int j=0; j<add.length; j++)
				sum += Integer.parseInt(add[j]);
			
			if(check_first) { 
				answer = sum; //ó������ ������ ������� �� �� ����
				check_first = false;
			}
			else 
				answer -= sum;
		}
		System.out.println(answer);
	}
}
