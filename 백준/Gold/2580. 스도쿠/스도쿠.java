import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int map[][] = new int[9][9];
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        for (int i=0; i<9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0)
                    list.add(new int[]{i,j});
            }
        }
        backTracking(0);
    }

    static void backTracking(int idx) {
        if(idx == list.size()) {
            for (int i=0; i<9; i++){
                for (int j=0; j<9; j++)
                    System.out.print(map[i][j] + " ");
                System.out.println();
            }
            System.exit(0);
        }

        int[] arr = list.get(idx);
        for (int i=1; i<=9; i++) {
            if(checkColumn(i, arr) && checkRow(i, arr) && checkGroup(i, arr)){
                map[arr[0]][arr[1]] = i;
                backTracking(idx+1);
                map[arr[0]][arr[1]] = 0;
            }
        }

    }

    static boolean checkColumn(int num, int[] arr){
        for (int i=0; i<9; i++){
            if(map[i][arr[1]] == num) {
                return false;
            }
        }
        return true;
    }

    static boolean checkRow(int num, int[] arr) {
        for (int j=0; j<9; j++){
            if(map[arr[0]][j] == num)
                return false;
        }
        return true;
    }

    static boolean checkGroup(int num, int[] arr) {
        int column = (arr[0]/3)*3;
        int row = (arr[1]/3)*3;
        for (int i=column; i<column+3; i++) {
            for (int j=row; j<row+3; j++) {
                if(map[i][j] == num)
                    return false;
            }
        }
        return true;
    }

}
