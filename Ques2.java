package com.tyss.array;

import java.util.Arrays;

public class Ques2 {

	public static void main(String[] args) {
		boolean flag = false;
		int arr[] = { 5, 3, 1, 2, 3, 4 };
		Arrays.sort(arr);
		int len= arr.length;
		System.out.println("Maximum product of 2 numbers is: " + (arr[len-1]* arr[len-2]));
		}
	}

