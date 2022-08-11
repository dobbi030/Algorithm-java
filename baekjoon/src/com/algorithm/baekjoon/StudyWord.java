import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudyWord {

	// 'A' + 32 == 'a'
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Pair> list = new ArrayList<>();
		String sentence = sc.next();

		for (char i = 'A'; i < 'Z' + 1; i++) {
			list.add(new Pair(i));
		}

		for (int i = 0; i < sentence.length(); i++) {
			list.get(Character.toUpperCase(sentence.charAt(i)) - 'A').count++;
		}

		list.sort((o1, o2) -> -Integer.compare(o1.count, o2.count));

		if (list.get(0).count == list.get(1).count)
			System.out.println("?");
		else
			System.out.println(list.get(0).alphabet);
	}

}

class Pair {
	char alphabet;
	int count;

	public Pair(char alphabet) {
		this.alphabet = alphabet;
		this.count = 0;
	}
}
