package com.tyss.array;

import java.util.HashSet;

public class Ques8 {

	static void removeDups(int[] arr, int n, int k) {

		HashSet<Integer> set = new HashSet<>();
		for (Integer integer : arr) {
			set.add(integer);
		}
		System.out.println(set);
	}

	public static void main(String args[]) {
		int[] arr = { 10, 20, 20, 30, 30, 40, 50, 50 };
		int n = arr.length;
		int k = 15;
		removeDups(arr, n, k);
	}
}