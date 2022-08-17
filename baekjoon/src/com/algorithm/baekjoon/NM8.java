import java.util.Arrays;
import java.util.Scanner;

public class NM8 {
	static int[] nums;
	static int[] input;
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		nums = new int[M];
		input = new int[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		Arrays.sort(input);

		perm(N, M, 0, 0);
		System.out.println(sb.toString());
	}

	private static void perm(int n, int m, int count, int start) {
		if (count == m) {
			for (int i = 0; i < m; i++) {
				sb.append(nums[i] + " ");
			}
			sb.append("\n");
		} else {
			for (int i = start; i < n; i++) {
				nums[count] = input[i];
				perm(n, m, count + 1, i);
			}
		}
	}

}
