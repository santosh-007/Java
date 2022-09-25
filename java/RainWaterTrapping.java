package com.java;

public class RainWaterTrapping {

	public static void main(String[] args) {

		int[] a = { 3, 1, 2, 4, 0, 1, 3, 2 };
		System.out.println(waterTrapped(a));
	}

	static int waterTrapped(int[] a) {
		int water = 0;
		int n = a.length;
		int[] left = new int[n];
		int[] right = new int[n];
		left[0] = a[0];
		right[n - 1] = a[n - 1];
		for (int i = 1; i < n; i++) {
			left[i] = a[i] > left[i - 1] ? a[i] : left[i - 1];
		}
		for (int i = n - 2; i >= 0; i--) {
			right[i] = a[i] > right[i + 1] ? a[i] : right[i + 1];
		}

		for (int j = 0; j < n; j++) {
			water += Math.min(left[j], right[j]) - a[j];
		}

		return water;

	}

}
