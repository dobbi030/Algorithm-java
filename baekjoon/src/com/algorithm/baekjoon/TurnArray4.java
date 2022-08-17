import java.util.Scanner;

public class TurnArray4 {
	static int[] order;
	static boolean[] visited;
	static int[][] rcs;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		int[][] map = new int[N][M];
		rcs = new int[K][3];
		order = new int[K];
		visited = new boolean[K];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < K; i++) {
			rcs[i][0] = sc.nextInt();
			rcs[i][1] = sc.nextInt();
			rcs[i][2] = sc.nextInt();
		}

		perm(map, K, 0);

		System.out.println(min);
	}

	private static void perm(int[][] map, int k, int count) {
		if (count == k) {
			int[][] result = rotate(map);
			int N = map.length;
			int M = map[0].length;

			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < M; j++) {
					sum += result[i][j];
				}

				min = Integer.min(min, sum);
			}

		} else {
			for (int i = 0; i < k; i++) {
				if (!visited[i]) {
					visited[i] = true;
					order[count] = i;
					perm(map, k, count + 1);

					visited[i] = false;
				}
			}
		}
	}

	private static int[][] rotate(int[][] map) {
		int K = order.length;
		int N = map.length;
		int M = map[0].length;
		int[][] origin = new int[N][M];
		int[][] result = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				origin[i][j] = map[i][j];
				result[i][j] = origin[i][j];
			}
		}

		for (int i = 0; i < K; i++) {
			int r = rcs[order[i]][0];
			int c = rcs[order[i]][1];
			int s = rcs[order[i]][2];

			// rotate 안 하는 부분 복사
			for (int line = 0; line < r - s - 1; line++) {
				for (int index = 0; index < M; index++) {
					result[line][index] = origin[line][index];
				}
			}

			for (int line = r - s - 1; line < r + s; line++) {
				for (int index = 0; index < c - s - 1; index++) {
					result[line][index] = origin[line][index];
				}
				for (int index = c + s; index < M; index++) {
					result[line][index] = origin[line][index];
				}
			}

			for (int line = r + s; line < N; line++) {
				for (int index = 0; index < M; index++) {
					result[line][index] = origin[line][index];
				}
			}

			// rotate
			for (int d = 0; d < s; d++) {
				// 맨 윗 줄, r = r - s - 1 + d
				for (int index = c - s - 1 + d; index < c + s - d; index++) {
					if (index == c + s - 1 - d) {
						result[r - s + d][index] = origin[r - s - 1 + d][index];
					} else {
						result[r - s - 1 + d][index + 1] = origin[r - s - 1 + d][index];
					}
				}

				// 맨 왼쪽 세로줄, c = c - s - 1 + d
				for (int line = r - s - 1 + d; line < r + s - d; line++) {
					if (line == r - s - 1 + d) {
						result[line][c - s + d] = origin[line][c - s - 1 + d];
					} else {
						result[line - 1][c - s - 1 + d] = origin[line][c - s - 1 + d];
					}
				}

				// 맨 오른쪽 세로줄, c = c + s - 1 - d
				for (int line = r - s - 1 + d; line < r + s - d; line++) {
					if (line == r + s - 1 - d) {
						result[line][c + s - 2 - d] = origin[line][c + s - 1 - d];
					} else {
						result[line + 1][c + s - 1 - d] = origin[line][c + s - 1 - d];
					}
				}

				// 맨 아래 줄, r = r + s - 1 - d
				for (int index = c - s - 1 + d; index < c + s - d; index++) {
					if (index == c - s - 1 + d) {
						result[r + s - 2 - d][index] = origin[r + s - 1 - d][index];
					} else {
						result[r + s - 1 - d][index - 1] = origin[r + s - 1 - d][index];
					}
				}
			}

			for (int k = 0; k < N; k++) {
				for (int j = 0; j < M; j++) {
					origin[k][j] = result[k][j];
				}
			}
		}

		return result;
	}

}
