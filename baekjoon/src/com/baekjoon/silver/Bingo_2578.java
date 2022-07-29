package com.baekjoon.silver;

import java.util.Scanner;

public class Bingo_2578 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Bingo_2578 temp = new Bingo_2578();
		int[][] map = new int[5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				int target = sc.nextInt();
				if (temp.matchBingo(map, target) >= 3) {
					System.out.println(5 * i + j + 1);
					return;
				}
			}
		}

	}

	public int matchBingo(int[][] map, int item) {
		int bingo = 0;
		int count = 0;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (map[i][j] == item) {
					map[i][j] = 0;
				}
			}
		}

		// 가로 줄 체크
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (map[i][j] == 0) {
					count++;
				}
			}

			if (count == 5) {
				bingo++;
			}
			count = 0;
		}

		// 세로 줄 체크
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (map[j][i] == 0) {
					count++;
				}
			}

			if (count == 5) {
				bingo++;
			}
			count = 0;
		}

		// 오른쪽 아래 대각선
		for (int i = 0; i < 5; i++) {
			if (map[i][i] == 0) {
				count++;
			}
		}
		if (count == 5) {
			bingo++;
		}
		count = 0;

		// 오른쪽 위 대각선 ㄹ
		for (int i = 0; i < 5; i++) {
			if (map[i][4 - i] == 0) {
				count++;
			}
		}
		if (count == 5) {
			bingo++;
		}
		count = 0;

		return bingo;
	}

}
