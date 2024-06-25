import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] word = sc.next().toLowerCase().toCharArray();
		int[] alphabet = new int[26];

		for (int i = 0; i < word.length; i++) {
			alphabet[word[i] - 'a']++;
		}

		int max = 0;
		boolean check = false;
		for (int i = 1; i < 26; i++) {
			if (alphabet[i] > alphabet[max]) {
				max = i;
				check = false;
			} else if (alphabet[i] == alphabet[max]) {
				check = true;
			}
		}

		if (check) {
			System.out.println("?");
		} else {
			System.out.println((char)(max + 'A'));
		}

		sc.close();
	}
}
