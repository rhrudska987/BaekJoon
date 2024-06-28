import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[][] sudoku = new int[9][9];
	static StringBuilder sb = new StringBuilder();
	static boolean find = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 9; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = c[j] - '0';
			}
		}
		
		solve(0, 0, 0);
		
		System.out.println(sb.toString());
		br.close();
	}
	
	static void solve(int col, int row, int cnt) {
		if (find) {
			return;
		}
		
		if (cnt == 81) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(sudoku[i][j]);
				}
				sb.append("\n");
			}
			find = true;
			return;
		}
		
		if (sudoku[col][row] != 0) {
			row++;
			if (row == 9) {
				row = 0;
				col++;
			}
			solve(col, row, cnt + 1);
			if (row == 0) {
				row = 9;
				col--;
			}
			row--;
		} else {
			for (int k = 1; k < 10; k++) {
				if (isPossible(col, row, k)) {
					sudoku[col][row] = k;
					row++;
					if (row == 9) {
						row = 0;
						col++;
					}
					solve(col, row, cnt + 1);
					if (row == 0) {
						row = 9;
						col--;
					}
					row--;
					sudoku[col][row] = 0;
				}
			}
		}
	}
	
	static boolean isPossible(int col, int row, int num) {
		for (int i = 0; i < 9; i++) {
			//같은 행 조사
			if (sudoku[col][i] == num) {
				return false;
			}
			
			//같은 열 조사
			if (sudoku[i][row] == num) {
				return false;
			}
			
		}
		
		//같은 구역 조사
		for (int i = col / 3 * 3; i < col / 3 * 3 + 3; i++) {
			for (int j = row / 3 * 3; j < row / 3 * 3 + 3; j++) {
				if (sudoku[i][j] == num) {
					return false;
				}
			}
		}
		
		return true;
	}
}
