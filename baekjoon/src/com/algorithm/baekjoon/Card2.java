import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Card2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i < N + 1; i++) {
			queue.offer(i);
		}

		while (queue.size() > 1) {
			queue.remove();
			int temp = queue.poll();
			queue.offer(temp);
		}

		System.out.println(queue.poll());
	}

}
