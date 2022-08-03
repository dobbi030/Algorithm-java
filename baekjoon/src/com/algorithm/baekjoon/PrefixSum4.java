import java.util.Scanner;

public class PrefixSum4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] map = new int[N + 1];
		int start = 0;
		int finish = 0;

		// N+1크기의 배열에 map[1]부터 map[i]까지의 합을 저장함. 맨 앞에는 map[1]을 위해 패딩값 0 저장.
		for (int i = 1; i < N + 1; i++) {
			map[i] = map[i - 1] + sc.nextInt();
		}

		for (int i = 0; i < M; i++) {
			start = sc.nextInt();
			finish = sc.nextInt();

			// for문은 시간초과 남.
//			int sum = 0;
//			for (int j = start - 1; j < finish; j++) {
//				sum += map[j];
//			}
//			System.out.println(sum);

			System.out.println(map[finish] - map[start - 1]);
		}
	}
}
