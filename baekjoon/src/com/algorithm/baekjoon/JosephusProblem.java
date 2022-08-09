import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class JosephusProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		List<Integer> circle = new ArrayList<>();

		for (int i = 1; i < N + 1; i++) {
			circle.add(i);
		}

		int startIndex = 0;

		System.out.print("<");
		while (circle.size() > 1) {
			int index = (startIndex + K - 1) % circle.size();
			System.out.print(circle.get(index) + ", ");
			circle.remove(index);
			startIndex = index;
		}
		System.out.println(circle.get(0) + ">");
	}

}
