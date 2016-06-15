package com.anbo.action;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class tests {
	//迭代求连号组合
	public static void main(String[] args) {
		int numbers[] = { 1,2,3,4,7 };
		Arrays.sort(numbers);
	//	System.out.println(JSON.toJSON(numbers));
		Map<Integer, Object> number_new = null;
		for (int i = 0; i < numbers.length - 1;) {
			// System.out.println("i is " + i);
			number_new = new HashMap<Integer, Object>();
			i = numberFenZu(number_new, numbers, i);
			System.out.println(number_new.keySet());
		}
		System.out.println("haha = "+number_new.size());
	}

	public static int numberFenZu(Map<Integer, Object> numbersList, int[] numbers, int index) {
		if (index < numbers.length - 1) {
			int number = numbers[index];
			int number_next = numbers[index + 1];
			// System.out.println(number + "|" + number_next);
			if (number + 1 == number_next) {
				numbersList.put(number, number);
				numbersList.put(number_next, number_next);
				index++;
				numberFenZu(numbersList, numbers, index);
			}
		}
		index++;

		return index;
	}

}
