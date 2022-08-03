import java.util.Scanner;

public class MakeColorPaper {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		System.out.println(sliceWhite(map, 0, 0, N, N));
		System.out.println(sliceBlue(map, 0, 0, N, N));
	}

	static boolean isAllWhite(int[][] map, int startR, int startC, int endR, int endC) {
		int color = 0;

		for (int i = startR; i < endR; i++) {
			for (int j = startC; j < endC; j++) {
				if (map[i][j] != color) {
					return false;
				}
			}
		}

		return true;
	}

	static boolean isAllBlue(int[][] map, int startR, int startC, int endR, int endC) {
		int color = 1;

		for (int i = startR; i < endR; i++) {
			for (int j = startC; j < endC; j++) {
				if (map[i][j] != color) {
					return false;
				}
			}
		}

		return true;
	}

	static int sliceWhite(int[][] map, int startR, int startC, int endR, int endC) {
		int middleR = (startR + endR) / 2;
		int middleC = (startC + endC) / 2;
		// 전체 색이 흰색이면 1 리턴
		if (isAllWhite(map, startR, startC, endR, endC))
			return 1;
		// 전체 색이 파란색이면 0 리턴
		if (isAllBlue(map, startR, startC, endR, endC))
			return 0;
		// 전체 색이 흰색이 아니면 4개로 쪼개서 다시 검사
		else {
			return sliceWhite(map, startR, startC, middleR, middleC) + sliceWhite(map, startR, middleC, middleR, endC)
					+ sliceWhite(map, middleR, startC, endR, middleC) + sliceWhite(map, middleR, middleC, endR, endC);
		}
	}

	static int sliceBlue(int[][] map, int startR, int startC, int endR, int endC) {
		int middleR = (startR + endR) / 2;
		int middleC = (startC + endC) / 2;
		// 전체 색이 파란색이면 1 리턴
		if (isAllBlue(map, startR, startC, endR, endC))
			return 1;
		// 전체 색이 흰색이면 0 리턴
		if (isAllWhite(map, startR, startC, endR, endC))
			return 0;
		// 전체 색이 파란색이 아니면 4개로 쪼개서 다시 검사
		else
			return sliceBlue(map, startR, startC, middleR, middleC) + sliceBlue(map, startR, middleC, middleR, endC)
					+ sliceBlue(map, middleR, startC, endR, middleC) + sliceBlue(map, middleR, middleC, endR, endC);
	}

}
