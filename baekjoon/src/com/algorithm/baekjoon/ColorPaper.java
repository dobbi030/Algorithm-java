import java.awt.Point;
import java.util.Scanner;

public class ColorPaper {

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
				if (map[i][j] == 1)
					count++;
			}
		}
		
		System.out.println(count);
	}

}
