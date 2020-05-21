package com.tyss.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Ques6 {

	public static void main(String[] args) {
		int arr[] = { 4, 3, 1, 2, 5, 4 , 4};
		Map<Integer, Integer> nameAndCount= new HashMap<Integer, Integer>();
		
		for (int number : arr) {
            Integer count = nameAndCount.get(number);
            if (count == null) {
                nameAndCount.put(number, 1);
            } else {
                nameAndCount.put(number, ++count);
            }
        }

        // Print duplicate elements from array in Java
        Set<Entry<Integer, Integer>> entrySet = nameAndCount.entrySet();
        for (Entry<Integer, Integer> entry : entrySet) {
            if (entry.getValue() > 1) {
                System.out.printf("duplicate element '%s' and count '%d' :", entry.getKey(), entry.getValue());
            }
        }
		
	}
}
