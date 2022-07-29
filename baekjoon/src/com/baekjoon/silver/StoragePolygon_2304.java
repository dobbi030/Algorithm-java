package com.baekjoon.silver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StoragePolygon_2304 {

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
