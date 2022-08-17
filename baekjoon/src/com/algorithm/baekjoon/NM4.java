import java.util.Scanner;

public class NM4 {
	static int[] num;
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		num = new int[M];

		permutation(N, M, 0, 1);

		System.out.println(sb.toString());
	}

	private static void permutation(int n, int m, int count, int start) {
		if (count == m) {
			ToString(m);
		} else {
			for (int i = start; i < n + 1; i++) {
				num[count] = i;
				permutation(n, m, count + 1, i);
			}
		}
	}

	public static void ToString(int m) {
		for (int i = 0; i < m; i++) {
			sb.append(num[i] + " ");
		}
		sb.append("\n");
	}
}
