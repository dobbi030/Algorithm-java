import java.util.Scanner;

public class IOIOI {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int length = 2 * N + 1;
		String S = sc.next();
		String P = "";
		StringBuffer sb = new StringBuffer();
		int[] pi = new int[length];
		int start = 0;
		int matched = 0;
		int count = 0;

		if (M < 2 * N + 1) {
			System.out.println(0);
			return;
		}

		for (int i = 0; i < N; i++) {
			sb.append("IO");
		}
		sb.append("I");
		P = sb.toString();

		// KMP
		while (start < M - length + 1) {
			if (matched < length && S.charAt(start + matched) == P.charAt(matched)) {
				matched++;
				if (matched == length) {
					count++;
					matched -= 2;
					start += 2;
				}
			} else {
				if (matched == 0)
					start++;
				else {
					start += matched - pi[matched - 1];
					matched = pi[matched - 1];
				}
			}
		}

		System.out.println(count);
	}
}