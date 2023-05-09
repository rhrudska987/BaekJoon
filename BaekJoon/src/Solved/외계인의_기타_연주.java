package Solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class �ܰ�����_��Ÿ_���� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());   //���� �ʿ����
		
		ArrayList<Integer>[] list = new ArrayList[N];  //ArrayList<Integer> �迭 ����
		for(int i=0; i<N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int line = Integer.parseInt(st.nextToken()); //�ٹ�ȣ �Է�
			int fret = Integer.parseInt(st.nextToken()); //����ȣ �Է�
			list[line].add(fret);  //�ٹ�ȣ�� �´� ����ȣ ���������� �Է�
		}
		
		int answer = 0; //���� ���� ����
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<N; i++) {
			if(list[i].size() == 0)  //i��° �ٿ� �ľ��� ���� ������ ���� �ٷ� �̵�
				continue;
			for(int j=0; j<list[i].size(); j++) {  
				int tmp = list[i].get(j);
				if(stack.isEmpty() || stack.peek() < tmp) { //������ ����ְų� ���� ������ �������� �� ���� ���ϰ��
					answer++;
					stack.push(tmp);
				}
				else if(stack.peek() == tmp) {
					continue;
				}
				else {
					while(!stack.isEmpty() && stack.peek() > tmp) {
						answer++;
						stack.pop();
					}
					if(!stack.isEmpty() && stack.peek() == tmp)
						continue;
					answer++;
					stack.push(tmp);
				}
			}
			stack.clear();
		}
		System.out.println(answer);
	}
}
