import java.util.Scanner;

public class TurnArray3 {

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
			int r = sc.nextInt();

			switch (r) {
			case 1:
				map = r1(map);
				break;
			case 2:
				map = r2(map);
				break;
			case 3:
				map = r3(map);
				break;
			case 4:
				map = r4(map);
				break;
			case 5:
				map = r5(map);
				break;
			case 6:
				map = r6(map);
				break;
			}
		}

		ToString(map);
	}

	// 가로 중간선 기준으로 상하 반전
	private static int[][] r1(int[][] map) {
		int N = map.length;
		int M = map[0].length;
		int[][] result = new int[N][M];

		for (int index = 0; index < M; index++) {
			for (int line = 0; line < N / 2; line++) {
				result[line][index] = map[N - line - 1][index];
				result[N - line - 1][index] = map[line][index];
			}
		}

		return result;
	}

	// 세로 중간선 기준으로 좌우 반전
	private static int[][] r2(int[][] map) {
		int N = map.length;
		int M = map[0].length;
		int[][] result = new int[N][M];

		for (int line = 0; line < N; line++) {
			for (int i = 0; i < M / 2; i++) {
				result[line][i] = map[line][M - i - 1];
				result[line][M - i - 1] = map[line][i];
			}
		}

		return result;
	}

	// 오른쪽으로 90도 회전
	private static int[][] r3(int[][] map) {
		int N = map.length;
		int M = map[0].length;
		int[][] result = new int[M][N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				result[i][j] = map[N - j - 1][i];
			}
		}

		return result;
	}

	// 왼쪽으로 90도 회전
	private static int[][] r4(int[][] map) {
		int N = map.length;
		int M = map[0].length;
		int[][] result = new int[M][N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				result[i][j] = map[j][M - i - 1];
			}
		}

		return result;
	}

	// 4분할 오른쪽으로 90도 회전(시계방향)
	private static int[][] r5(int[][] map) {
		int N = map.length;
		int M = map[0].length;
		int[][] result = new int[N][M];

		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				result[i][j + M / 2] = map[i][j];
			}
		}

		for (int i = 0; i < N / 2; i++) {
			for (int j = M / 2; j < M; j++) {
				result[i + N / 2][j] = map[i][j];
			}
		}

		for (int i = N / 2; i < N; i++) {
			for (int j = M / 2; j < M; j++) {
				result[i][j - M / 2] = map[i][j];
			}
		}

		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				result[i - N / 2][j] = map[i][j];
			}
		}

		return result;
	}

	private static int[][] r6(int[][] map) {
		int N = map.length;
		int M = map[0].length;
		int[][] result = new int[N][M];

		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				result[i + N / 2][j] = map[i][j];
			}
		}

		for (int i = 0; i < N / 2; i++) {
			for (int j = M / 2; j < M; j++) {
				result[i][j - M / 2] = map[i][j];
			}
		}

		for (int i = N / 2; i < N; i++) {
			for (int j = M / 2; j < M; j++) {
				result[i - N / 2][j] = map[i][j];
			}
		}

		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				result[i][j + M / 2] = map[i][j];
			}
		}

		return result;
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

}
