import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class NM10 {
	static int[] num;
	static int[] input;
	static TreeSet<String> output = new TreeSet<>();
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		input = new int[N];
		num = new int[M];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		Arrays.sort(input);

		perm(N, M, 0, 0);

		System.out.println(sb.toString());
	}

	private static void perm(int n, int m, int count, int start) {
		if (count == m) {
			String s = "";
			for (int i = 0; i < m; i++) {
				s += num[i] + " ";
			}
			if (output.add(s)) {
				sb.append(s + "\n");
			}
		} else {
			for (int i = start; i < n; i++) {
				num[count] = input[i];
				perm(n, m, count + 1, i + 1);
			}
		}
	}

}
