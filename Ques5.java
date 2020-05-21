package com.tyss.array;

public class Ques5 {

	public static void main(String[] args) {
		int arr[] = { 0, 3, 1, 2, 5, 4 , -9};
		int largest= arr[0];
		int smallest= arr[0];
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]>largest) {
				largest= arr[i];
			}
			
			if (arr[i]< smallest) {
				smallest= arr[i];
			}
		}
		
		System.out.println("Smallest is: " + smallest);
		System.out.println("Largest is: " + largest);
		
	}
}
