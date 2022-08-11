import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Set {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] S = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int[] A = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		int[] E = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < N; i++) {
			String order = sc.next();
			int num = 0;
			switch (order) {
			case "add":
				num = sc.nextInt();
				S[num - 1] = 1;
				break;
			case "remove":
				num = sc.nextInt();
				S[num - 1] = 0;
				break;
			case "check":
				num = sc.nextInt();
				sb.append(S[num - 1] + "\n");
				break;
			case "toggle":
				num = sc.nextInt();
				S[num - 1] = (S[num - 1] + 1) % 2;
				break;
			case "all":
				S = A.clone();
				break;
			case "empty":
				S = E.clone();
				break;
			}
		}
		System.out.println(sb.toString());
	}
}
