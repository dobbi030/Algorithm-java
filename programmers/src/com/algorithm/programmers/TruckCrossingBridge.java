package com.algorithm.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class TruckCrossingBridge {
	// 큐 이용하는건 알겠는데 자료구조를 잘 몰라서 못 풀었음...
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Integer> bridge = new LinkedList<>();

		for (int truck : truck_weights) {
			if (sumA)
				bridge.add(truck);
		}

		return 0;
	}

	public int sumArray(Queue<Integer> bridge, int start, int end) {
		int sum = 0;

		for (int i = start; i < end; i++) {
			sum += bridge.;
		}

		return sum;
	}

	public void goNext(int[] bridge) {
		for (int i = 0; i < bridge.length - 1; i++) {
			bridge[i] = bridge[i + 1];
		}
		bridge[bridge.length - 1] = 0;
	}

}
