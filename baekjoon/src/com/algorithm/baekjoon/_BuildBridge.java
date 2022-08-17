
// BOJ 1010 다리 놓기

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class _BuildBridge {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			BigInteger i = new BigInteger(M + "");
			BigInteger j = new BigInteger(N + "");
			BigInteger result = new BigInteger("1");

			for (; i.intValue() > M - N; i = i.subtract(new BigInteger("1"))) {
				result = result.multiply(i);
			}

			for (; j.intValue() > 0; j = j.subtract(new BigInteger("1"))) {
				result = result.divide(j);
			}

			System.out.println(result.intValue());
		}
	}

}
