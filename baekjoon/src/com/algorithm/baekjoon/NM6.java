import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NM6 {
	static int[] nums;
	static List<Integer> input = new ArrayList<>();
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		nums = new int[M];

		for (int i = 0; i < N; i++) {
			input.add(sc.nextInt());
		}

		input.sort((o1, o2) -> Integer.compare(o1, o2));

		permutation(N, M, 0, 0);
		System.out.println(sb.toString());
	}

	private static void permutation(int n, int m, int count, int start) {
		if (count == m) {
			ToString(m);
		} else {
			for (int i = start; i < n; i++) {
				nums[count] = input.get(i);
				permutation(n, m, count + 1, i + 1);
			}
		}
	}

	private static void ToString(int m) {
		for (int i = 0; i < m; i++) {
			sb.append(nums[i] + " ");
		}
		sb.append("\n");
	}

}
