import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        int cut = (int) Math.round(testCase * 0.15);

        ArrayList<Integer> list = new ArrayList<>();
        for (int a=0; a<testCase; a++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);
        int size = testCase-(cut*2);

        int result = 0;
        for (int a=cut; a<size+cut; a++) {
            result += list.get(a);
        }

        result = (int) Math.round((double) result / size);
        System.out.println(result);
    }
}