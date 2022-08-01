package com.algorithm.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StoragePolygon_2304 {
	// stack으로 가장 높은 곳에서부터 오른쪽으로 탐색해서 새로운 아이템이랑 스택 아이템이랑 비교해서 스택 아이템이 작으면 pop,
	// 큰거 나오면 새로운 아이템 넣어주기.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		List<Integer> sortedPoles = new ArrayList<>();
		ArrayList<Integer> H = new ArrayList<>(1000);

		for (int i = 0; i < N; i++) {
			int index = sc.nextInt();
			H.add(index, sc.nextInt());
			sortedPoles.add(H.get(index));
		}

		H.trimToSize();
		sortedPoles.sort((a, b) -> -Integer.compare(a, b));
		System.out.println(H);
		System.out.println(sortedPoles);

		int area = 0;

	}

}
