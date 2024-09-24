import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		int size = Integer.parseInt(br.readLine());
		
		int[] num = new int[10001];
		while(size --> 0) {
			num[Integer.parseInt(br.readLine()) - 1]++;
		}
		
		int max = 0, answer = 0;
		for(int i = 0; i < num.length; i++) {
			if(max < num[i]) {
				max = num[i];
				answer = i + 1;
			}
		}
		System.out.print(answer);
	}
}