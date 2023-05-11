package Solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 임스와_함께하는_미니게임 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		String game = st.nextToken();
		
		HashSet<String> players = new HashSet<String>();
		for(int i=0; i<N; i++)
			players.add(br.readLine());
		
		if(game.equals("Y"))
			System.out.println(players.size());
		else if(game.equals("F")) 
			System.out.println(players.size()/2);
		else
			System.out.println(players.size()/3);
	}
}
