
// BOJ 15663 N과 M(9)

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class _NM9 {
	static int[] num;
	static int[] input;
	static boolean[] visited;
	static TreeSet<String> output = new TreeSet<>();
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		input = new int[N];
		visited = new boolean[N];
		num = new int[M];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		Arrays.sort(input);

		perm(N, M, 0);

		System.out.println(sb.toString());
	}

	private static void perm(int n, int m, int count) {
		if (count == m) {
			String s = "";
			for (int i = 0; i < m; i++) {
				s += num[i] + " ";
			}
			if (output.add(s)) {
				sb.append(s + "\n");
			}
		} else {
			for (int i = 0; i < n; i++) {
				if (!visited[i]) {
					visited[i] = true;
					num[count] = input[i];
					perm(n, m, count + 1);

					visited[i] = false;
				}
			}
		}
	}
}
