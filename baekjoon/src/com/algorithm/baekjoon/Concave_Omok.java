import java.util.Scanner;

public class Concave_Omok {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] board = new int[19][19];
		// 오른쪽 위, 오른쪽, 오른쪽 아래, 아래
		int[] dr = { -1, 0, +1, +1 };
		int[] dc = { +1, +1, +1, 0 };
		// 왼쪽 아래, 왼쪽, 왼쪽 위, 위
		int[] nr = { +1, 0, -1, -1 };
		int[] nc = { -1, -1, -1, 0 };
		int count = 0;

		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				// 바둑돌 5개가 완성 되는지 체크
				if (board[i][j] == 1) {
					count++;
					for (int d = 0; d < 4; d++) {
						if (isInBoard(board, i + dr[d], j + dc[d]) && board[i + dr[d]][j + dc[d]] == 1) {
							count++;
							int multi = 2;
							while (isInBoard(board, i + dr[d] * multi, j + dc[d] * multi)
									&& board[i + dr[d] * multi][j + dc[d] * multi] == 1) {
								count++;
								multi++;
							}
							if (count == 5) {
								// 반대쪽에 추가로 연결되는 바둑돌이 있는지 체크
								if (!(isInBoard(board, i + nr[d], j + nc[d]) && board[i + nr[d]][j + nc[d]] == 1)) {
									System.out.println(1);
									System.out.println((i + 1) + " " + (j + 1));
									return;
								}
							}
							count = 1;
						}
					}
				} else if (board[i][j] == 2) {
					count++;
					for (int d = 0; d < 4; d++) {
						if (isInBoard(board, i + dr[d], j + dc[d]) && board[i + dr[d]][j + dc[d]] == 2) {
							count++;
							int multi = 2;
							while (isInBoard(board, i + dr[d] * multi, j + dc[d] * multi)
									&& board[i + dr[d] * multi][j + dc[d] * multi] == 2) {
								count++;
								multi++;
							}
							if (count == 5) {
								// 반대쪽에 추가로 연결되는 바둑돌이 있는지 체크
								if (!(isInBoard(board, i + nr[d], j + nc[d]) && board[i + nr[d]][j + nc[d]] == 2)) {
									System.out.println(2);
									System.out.println((i + 1) + " " + (j + 1));
									return;
								}
							}
							count = 1;
						}
					}
				}
				count = 0;
			}
		}
		System.out.println(0);
	}

	static boolean isInBoard(int[][] board, int r, int c) {
		if (r > board.length - 1 || r < 0)
			return false;
		if (c > board[0].length - 1 || c < 0)
			return false;
		return true;
	}

}
