import java.util.Scanner;

public class NM1 {
	static int[] num;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		num = new int[M];
		visited = new boolean[N];

		permutation(N, M, 0);
	}

	private static void permutation(int n, int m, int count) {
		if (count == m) {
			ToString(m);
		} else {
			for (int i = 0; i < n; i++) {
				if (!visited[i]) {
					visited[i] = true;
					num[count] = i + 1;
					permutation(n, m, count + 1);

					visited[i] = false;
				}
			}
		}
	}

	public static void ToString(int m) {
		for (int i = 0; i < m; i++) {
			System.out.print(num[i] + " ");
		}
		System.out.println();
	}

}
