package com.learnSpring.LearnSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SpringBootApplication
public class LearnSpringApplication {

	public static void main(String[] args) {
//		SpringApplication.run(LearnSpringApplication.class, args);
		int[] numbers = {10,2,8,1, 4,23,1,4};
		int[] selectionNumbers = {10,2,8,1, 4,23,1,4};

		LearnSpringApplication.selectionSort(selectionNumbers);
		LearnSpringApplication.bobbleSort(numbers);
		LearnSpringApplication.printArray(numbers);
	}

	private static void selectionSort (int[] array) {
		int sortedIndex = array.length - 1;
		for (int i : array) {
			loopArray(array, sortedIndex);
			sortedIndex--;
		}
	}

	private static void loopArray(int[] array, int length) {
		for (int j = 0; j <= length; j++) {
			if (isGreater(array[j], array[length])) {
				LearnSpringApplication.swapElements(j, length, array);
			}
		}
	}

	private static void bobbleSort (int[] array) {
		for (int i : array) {
			for (int x = 0; x < array.length; x++) {
				int x2 = x;
				if (x == array.length - 1) {
					break;
				} else if (isGreater(array[x], array[++x2])) {
					LearnSpringApplication.swapElements(x, x2, array);
				}
			}
		}
	}

	private static boolean isGreater (int value1, int value2) {
		return value1 > value2;
	}

	private static void swapElements (int pos1, int pos2, int[] array) {
		int temp = array[pos1];
		array[pos1] = array[pos2];
		array[pos2] = temp;
	}

	private static void printArray(int[] array) {
		String output = Arrays.stream(array)
				.mapToObj(String::valueOf)
				.collect(Collectors.joining(" "));

		System.out.println(output);
	}

}
