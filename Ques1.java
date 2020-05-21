package com.tyss.array;

public class Ques1 {

	public static void main(String[] args) {

		int arr[] = new int[100];
		for (int i = 0; i < 100; i++) {
			arr[i] = i + 1;
		}
		arr[35]=0;
		int n = arr.length;
		int sum = n * (n + 1) / 2;
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			temp = temp + arr[i];
		}

		if (sum == temp) {
			System.out.println("All numbers are present");
		} else {
			System.out.println("Missing Number is: " + (sum - temp));
		}
	}
}
