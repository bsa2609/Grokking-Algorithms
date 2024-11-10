package bsa.study.chapter3;

import bsa.study.Utils;

public class MaxElementOfArray {
    public static int find(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        } else {
            int maxElementOfSubArray = find(Utils.getSubArray(numbers, 1, numbers.length));
            return numbers[0] > maxElementOfSubArray ? numbers[0] : maxElementOfSubArray;
        }
    }
}
