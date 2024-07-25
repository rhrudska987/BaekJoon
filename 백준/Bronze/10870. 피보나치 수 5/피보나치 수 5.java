import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {	
	static int[] arr = {0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597,2584,4181,6765};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(arr[Integer.parseInt(br.readLine())]);
		br.close();
	}
}