package bsa.study.chapter1;

public class BinarySearch {
    public static Integer find(int[] numbers, int item) {
        if (numbers.length == 0) {
            return null;
        }

        int low = 0;
        int high = numbers.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (numbers[mid] == item) {
                return mid;
            } else if (numbers[mid] < item) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }
}
