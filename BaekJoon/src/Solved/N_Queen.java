package Solved;

import java.io.IOException;
import java.util.Scanner;

public class N_Queen {
	
	static int board[][];
	static int N;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		board = new int[N][N];
		NQueen(0);
		System.out.println(answer);
	}
	
	public static void NQueen(int y) {
		if(y == N) { //������ ������ ��ġ�� �Ǿ��ٸ�, answer++
			answer++;
			return;
		}
			
		for(int x=0; x<N; x++) { //x�� row���� �ǹ��ϸ� y�� column���� �ǹ�
			if(check_col(x, y) && check_diagonal(x, y)) { //���� ��� �밢���� ���� ���ٸ�
				board[y][x] = 1; //���� ��ġ�� ���� ��ġ
				NQueen(y + 1);   //���� ������ �̵�
				board[y][x] = 0; //���� ���忡�� ����
			}
		}
	}
	
	public static boolean check_col(int x, int y) {
		for(int i=y; i<N; i++) {
			if(board[i][x] == 1)
				return false;
		}
		for(int i=y; i>=0; i--) {
			if(board[i][x] == 1)
				return false;
		}
		return true;
	}
	
	public static boolean check_diagonal(int x, int y) {
		int tmpX = x;
		int tmpY = y;
		do { //���� �� �밢�� üũ
			if(board[tmpY][tmpX] == 1)
				return false;
			tmpX--; tmpY--;
		} while(tmpX >= 0 && tmpY >= 0);
		
		tmpX = x;
		tmpY = y;
		do { //���� �Ʒ� �밢�� üũ
			if(board[tmpY][tmpX] == 1)
				return false;
			tmpX--; tmpY++;
		} while(tmpX >= 0 && tmpY < N);
		
		tmpX = x;
		tmpY = y;
		do { //������ �� �밢�� üũ
			if(board[tmpY][tmpX] == 1)
				return false;
			tmpX++; tmpY--;
		} while(tmpX < N && tmpY >= 0);
		
		do { //������ �Ʒ� �밢�� üũ
			if(board[y][x] == 1)
				return false;
			x++; y++;
		} while(x < N && y < N);
		return true;
	}
}