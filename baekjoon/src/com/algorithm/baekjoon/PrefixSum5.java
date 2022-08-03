import java.util.Scanner;

public class PrefixSum5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N + 1][N + 1];
		StringBuilder sb = new StringBuilder();

		// a b
		// c d
		// 각 item은 0,0부터 i,j까지의 사각형 모양의 합이다. 이때, d = 원본 배열의 원소 + b + c - a의 식을 구할 수 있다.
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				map[i][j] = sc.nextInt() + map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1];
			}
		}

		for (int i = 0; i < M; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();

			sb.append(map[x2][y2] - map[x2][y1 - 1] - map[x1 - 1][y2] + map[x1 - 1][y1 - 1]);
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}
