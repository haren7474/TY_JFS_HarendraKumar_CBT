package com.tyss.array;

public class Ques10 {

	static void commomElements(int[] arr1, int n1, int[] arr2, int n2) {
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if(arr1[i]==arr2[j]) {
					System.out.println(arr1[i]);
				}
			}
		}
	}

	public static void main(String args[]) {
		int[] arr1 = { 21,34,41,22, 35 };
		int[] arr2 = { 61, 34, 45, 21,11 };
		int n1 = arr1.length;
		int n2= arr2.length;
		commomElements(arr1, n1, arr2, n2);
	}
}