package bsa.study.chapter3;

import bsa.study.Utils;

public class SumOfElementsOfArray {
    public static int calculate(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        } else {
            return numbers[0] + calculate(Utils.getSubArray(numbers, 1, numbers.length));
        }
    }
}
