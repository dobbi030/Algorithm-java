import java.util.Scanner;

public class TurnArray1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int R = sc.nextInt();
		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < R; i++) {
			map = turn(map);
		}

		ToString(map);
	}

	private static void ToString(int[][] map) {
		int N = map.length;
		int M = map[0].length;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int[][] turn(int[][] map) {
		int N = map.length;
		int M = map[0].length;
		int min = Integer.min(N, M);
		int[][] result = new int[N][M];

		for (int i = 0; i < min / 2; i++) {
			// 맨 윗 줄 회전, r = i
			for (int index = i; index < M - i; index++) {
				if (index == i) {
					result[i + 1][index] = map[i][index];
				} else {
					result[i][index - 1] = map[i][index];
				}
			}

			// 왼쪽 끝 c = i
			for (int line = i; line < N - i; line++) {
				if (line == N - i - 1) {
					result[line][i + 1] = map[line][i];
				} else {
					result[line + 1][i] = map[line][i];
				}
			}

			// 오른쪽 끝 c = M - i - 1
			for (int line = i; line < N - i; line++) {
				if (line == i) {
					result[line][M - i - 2] = map[line][M - i - 1];
				} else {
					result[line - 1][M - i - 1] = map[line][M - i - 1];
				}
			}

			// 맨 밑 줄 회전, r = N - i - 1
			for (int index = i; index < M - i; index++) {
				if (index == M - i - 1) {
					result[N - i - 2][index] = map[N - i - 1][index];
				} else {
					result[N - i - 1][index + 1] = map[N - i - 1][index];
				}
			}
		}
		return result;
	}

}
