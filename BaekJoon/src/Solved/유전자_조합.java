package Solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class 유전자_조합 {
	static HashSet<Character> set = new HashSet<>();
	static HashSet<String> genes = new HashSet<>();
	
	public static void main(String[] args) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int N = Integer.parseInt(br.readLine());
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 for(int i=0; i<N; i++) {
			 String gen = st.nextToken();
			 if(genes.contains(gen)) {
				 if(gen.charAt(0) > gen.charAt(1))
					 set.add(gen.charAt(0));
				 else
					 set.add(gen.charAt(1));
			 }
			 else 
				 genes.add(gen);
		 }
		 
		 Iterator<String> iter = genes.iterator();
		 while(iter.hasNext()) {
			 String gene =  iter.next();
			 Iterator<String> iter1 = genes.iterator();
			 while(iter1.hasNext()) {
				 String secondGene = iter1.next();
				 if(!gene.equals(secondGene)) {
					 if(gene.charAt(0) > secondGene.charAt(1))
						 set.add(gene.charAt(0));
					 else
						 set.add(secondGene.charAt(1));
					 if(secondGene.charAt(0) > gene.charAt(1))
						 set.add(secondGene.charAt(0));
					 else
						 set.add(gene.charAt(1));
				 }
			 }
		 }
		 
		 ArrayList<Character> list = new ArrayList<>();
		 Iterator<Character> iter2 = set.iterator();
		 while(iter2.hasNext())
			 list.add(iter2.next());
		 
		 Collections.sort(list);
		 
		 System.out.println(list.size());
		 for(int i=0; i<list.size(); i++)
			 System.out.print(list.get(i) + " ");
	}
}
