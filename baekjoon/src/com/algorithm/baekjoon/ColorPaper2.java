import java.awt.Point;
import java.util.Scanner;

public class ColorPaper2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[100][100];
		int count = 0;

		for (int i = 0; i < N; i++) {
			Point p = new Point(sc.nextInt(), sc.nextInt());

			for (int x = p.x; x < p.x + 10; x++) {
				for (int y = p.y; y < p.y + 10; y++) {
					map[x][y] = 1;
				}
			}
		}

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				count += isLine(map, i, j);
			}
		}

		System.out.println(count);
	}

	public static int isLine(int[][] map, int x, int y) {
		int count = 0;
		if (map[x][y] == 1) {
			if (x == 0)
				count++;
			else if (map[x - 1][y] == 0)
				count++;

			if (y == 0)
				count++;
			else if (map[x][y - 1] == 0)
				count++;

			if (x == 99)
				count++;
			else if (map[x + 1][y] == 0)
				count++;

			if (y == 99)
				count++;
			else if (map[x][y + 1] == 0)
				count++;
		}
		return count;
	}

}
