import java.util.Arrays;
import java.util.Scanner;

public class NM7 {
	static int[] num;
	static int[] input;
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		num = new int[M];
		input = new int[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		Arrays.sort(input);

		permutation(N, M, 0);
		System.out.println(sb.toString());
	}

	private static void permutation(int n, int m, int count) {
		if (count == m) {
			for (int i = 0; i < m; i++) {
				sb.append(num[i] + " ");
			}
			sb.append("\n");
		} else {
			for (int i = 0; i < n; i++) {
				num[count] = input[i];
				permutation(n, m, count + 1);
			}
		}
	}

}
