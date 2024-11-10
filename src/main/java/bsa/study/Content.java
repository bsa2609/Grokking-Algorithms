package bsa.study;

import bsa.study.chapter1.BinarySearch;
import bsa.study.chapter2.SelectionSort;
import bsa.study.chapter3.BinarySearchRecursively;
import bsa.study.chapter3.Countdown;
import bsa.study.chapter3.Factorial;
import bsa.study.chapter3.MaxElementOfArray;
import bsa.study.chapter3.SumOfElementsOfArray;

import java.util.Arrays;

public class Content {
    public static void chapter1() {
        System.out.println("Chapter 1");

        // Binary search
        System.out.println("Binary search");

        int[] numbers1 = new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17};
        int number1 = 13;
        System.out.printf("Index of %d in array is %d%n",
                number1, BinarySearch.find(numbers1, number1));

        int[] numbers2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        int number2_1 = 5;
        System.out.printf("Index of %d in array is %d%n",
                number2_1, BinarySearch.find(numbers2, number2_1));

        int number2_2 = 15;
        System.out.printf("Index of %d in array is %d%n",
                number2_2, BinarySearch.find(numbers2, number2_2));

        int[] numbers3 = new int[]{1};
        int number3_1 = 1;
        System.out.printf("Index of %d in array is %d%n",
                number3_1, BinarySearch.find(numbers3, number3_1));

        int number3_2 = 2;
        System.out.printf("Index of %d in array is %d%n",
                number3_2, BinarySearch.find(numbers3, number3_2));
    }

    public static void chapter2() {
        System.out.println("Chapter 2");

        // Selection sort
        System.out.println("Selection sort");

        int[] numbers11 = new int[]{10, 8, 2, 1, 6, 4, 5, 9, 3, 7, 2, 4, 6, 8, 10};
        System.out.println("Unsorted array: " + Arrays.toString(numbers11));

        int[] numbers11Sorted = SelectionSort.sort(numbers11);
        System.out.println("Sorted array: " + Arrays.toString(numbers11Sorted));

        int[] numbers12 = new int[]{-50, 30, 0, -20, 0, 20, 10, 0, 100};
        System.out.println("Unsorted array: " + Arrays.toString(numbers12));

        int[] numbers12Sorted = SelectionSort.sort(numbers12);
        System.out.println("Sorted array: " + Arrays.toString(numbers12Sorted));
    }

    public static void chapter3() {
        System.out.println("Chapter 3");

        // Recursion
        System.out.println("Start countdown:");
        Countdown.count(5);

        int i = 5;
        System.out.printf("Calculate factorial: %d\n", i);
        System.out.println(Factorial.calculate(i));

        int[] numbers1 = Utils.getArrayWithRandomInt(5, 1, 10);
        System.out.printf("Calculate sum of elements of array: %s\n", Arrays.toString(numbers1));
        System.out.println(SumOfElementsOfArray.calculate(numbers1));

        int[] numbers2 = Utils.getArrayWithRandomInt(15, 1, 50);
        System.out.printf("Find maximum element of array: %s\n", Arrays.toString(numbers2));
        System.out.println(MaxElementOfArray.find(numbers2));

        int[] numbers3 = SelectionSort.sort(Utils.getArrayWithRandomInt(15, 1, 50));
        int item = Utils.getRandomInt(1, 50);
        System.out.printf("Index of %d in array %s%n", item, Arrays.toString(numbers3));
        System.out.println(BinarySearchRecursively.findUsingSubArrays(numbers3, item));
        System.out.println(BinarySearchRecursively.findUsingIndexes(numbers3, item));
    }
}
