package bsa.study.chapter3;

import bsa.study.Utils;

public class BinarySearchRecursively {
    public static Integer find (int[] numbers, int item) {
        if (numbers.length == 1) {
            return numbers[0] == item ? 0 : null;

        } else {
            int mid = numbers.length / 2;
            if (numbers[mid] == item) {
                return mid;

            } else if (numbers[mid] > item) {
                Integer index = find(Utils.getSubArray(numbers, 0, mid), item);
                return index;

            } else {
                Integer index = find(Utils.getSubArray(numbers, mid + 1, numbers.length), item);
                return index != null ? mid + 1 + index : null;
            }
        }
    }
}
