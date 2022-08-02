import java.util.Scanner;

public class OnOffSwitch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nSwitch = sc.nextInt();
		int[] map = new int[nSwitch];

		for (int i = 0; i < nSwitch; i++) {
			map[i] = sc.nextInt();
		}

		int nStudent = sc.nextInt();
		for (int i = 0; i < nStudent; i++) {
			int sex = sc.nextInt();
			int number = sc.nextInt();

			if (sex == 1) {
				for (int index = number - 1; index < map.length; index += number) {
					map[index] = (map[index] + 1) % 2;
				}
			} else {
				number--;
				int d = 1;
				map[number] = (map[number] + 1) % 2;

				while (number + d < map.length && number - d > -1 && map[number + d] == map[number - d]) {
					map[number + d] = (map[number + d] + 1) % 2;
					map[number - d] = (map[number - d] + 1) % 2;
					d++;
				}
			}

		}
		for (int i = 0; i < nSwitch; i++) {
			System.out.print(map[i] + " ");
			if (i % 20 == 19) {
				System.out.println();
			}
		}
	}

}
