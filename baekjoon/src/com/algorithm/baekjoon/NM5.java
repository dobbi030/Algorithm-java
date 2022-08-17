import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NM5 {
	static int[] num;
	static boolean[] visited;
	static StringBuffer sb = new StringBuffer();
	static List<Integer> input;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		num = new int[M];
		visited = new boolean[N];
		input = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			input.add(sc.nextInt());
		}

		input.sort((o1, o2) -> Integer.compare(o1, o2));

		permutation(N, M, 0);

		System.out.println(sb.toString());
	}

	private static void permutation(int n, int m, int count) {
		if (count == m) {
			ToString(m);
		} else {
			for (int i = 0; i < n; i++) {
				if (!visited[i]) {
					visited[i] = true;
					num[count] = input.get(i);
					permutation(n, m, count + 1);

					visited[i] = false;
				}
			}
		}
	}

	private static void ToString(int m) {
		for (int i = 0; i < m; i++) {
			sb.append(num[i] + " ");
		}
		sb.append("\n");
	}

}
