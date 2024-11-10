package bsa.study.chapter3;

import bsa.study.Utils;

public class BinarySearchRecursively {
    public static Integer findUsingSubArrays (int[] numbers, int item) {
        if (numbers.length == 1) {
            return numbers[0] == item ? 0 : null;

        } else {
            int mid = numbers.length / 2;
            if (numbers[mid] == item) {
                return mid;

            } else if (numbers[mid] > item) {
                Integer index = findUsingSubArrays(Utils.getSubArray(numbers, 0, mid), item);
                return index;

            } else {
                Integer index = findUsingSubArrays(Utils.getSubArray(numbers, mid + 1, numbers.length), item);
                return index != null ? mid + 1 + index : null;
            }
        }
    }

    public static Integer findUsingIndexes(int[] numbers, int item, int low, int high) {
        if (low > high) {
            return null;

        } else {
            int mid = (high + low) / 2;

            if (numbers[mid] == item) {
                return mid;

            } else if (numbers[mid] > item) {
                return findUsingIndexes(numbers, item, low, mid - 1);

            } else {
                return findUsingIndexes(numbers, item, mid + 1, high);
            }
        }
    }

    public static Integer findUsingIndexes(int[] numbers, int item) {
        return findUsingIndexes(numbers, item, 0, numbers.length - 1);
    }
}
