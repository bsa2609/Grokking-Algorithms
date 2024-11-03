package bsa.study;

import bsa.study.chapter1.BinarySearch;

public class App {
    public static void main(String[] args) {
        // Chapter 1

        // Binary search

        int[] numbers1 = new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17};
        int number1 = 13;
        System.out.println(String.format("Index of %d in array is %d",
                number1, BinarySearch.find(numbers1, number1)));

        int[] numbers2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        int number2 = 5;
        System.out.println(String.format("Index of %d in array is %d",
                number2, BinarySearch.find(numbers2, number2)));

        int number3 = 15;
        System.out.println(String.format("Index of %d in array is %d",
                number3, BinarySearch.find(numbers2, number3)));
    }
}
