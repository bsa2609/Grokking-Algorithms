package bsa.study.chapter4;

import bsa.study.Utils;

public class QuickSort {
    public static int[] sortPivotIsFirstElement(int[] numbers) {
        if (numbers.length < 2) {
            return numbers;

        } else {
            int pivotIndex = 0;
            int pivot = numbers[pivotIndex];

            int lessCount = 0;
            int greaterCount = 0;

            for (int i = 0; i < numbers.length; i++) {
                if (i != pivotIndex) {
                    if (numbers[i] <= pivot) {
                        lessCount++;

                    } else {
                        greaterCount++;
                    }
                }
            }

            int[] less = new int[lessCount];
            int[] greater = new int[greaterCount];

            int lessIndex = 0;
            int greaterIndex = 0;

            for (int i = 0; i < numbers.length; i++) {
                if (i != pivotIndex) {
                    if (numbers[i] <= pivot) {
                        less[lessIndex] = numbers[i];
                        lessIndex++;

                    } else {
                        greater[greaterIndex] = numbers[i];
                        greaterIndex++;
                    }
                }
            }

            int index = 0;

            for (int lessNumber : sortPivotIsFirstElement(less)) {
                numbers[index] = lessNumber;
                index++;
            }

            numbers[index] = pivot;
            index++;

            for (int greaterNumber: sortPivotIsFirstElement(greater)) {
                numbers[index] = greaterNumber;
                index++;
            }

            return numbers;
        }
    }

    public static int[] sortPivotIsRandomElement(int[] numbers) {
        if (numbers.length < 2) {
            return numbers;

        } else {
            int pivotIndex = Utils.getRandomInt(0, numbers.length - 1);
            int pivot = numbers[pivotIndex];

            int lessCount = 0;
            int greaterCount = 0;

            for (int i = 0; i < pivotIndex; i++) {
                if (numbers[i] <= pivot) {
                    lessCount++;

                } else {
                    greaterCount++;
                }
            }

            for (int i = pivotIndex + 1; i < numbers.length; i++) {
                if (numbers[i] <= pivot) {
                    lessCount++;

                } else {
                    greaterCount++;
                }
            }

            int[] less = new int[lessCount];
            int[] greater = new int[greaterCount];

            int lessIndex = 0;
            int greaterIndex = 0;

            for (int i = 0; i < pivotIndex; i++) {
                if (numbers[i] <= pivot) {
                    less[lessIndex++] = numbers[i];

                } else {
                    greater[greaterIndex++] = numbers[i];
                }
            }

            for (int i = pivotIndex + 1; i < numbers.length; i++) {
                if (numbers[i] <= pivot) {
                    less[lessIndex++] = numbers[i];

                } else {
                    greater[greaterIndex++] = numbers[i];
                }
            }

            int index = 0;

            for (int lessNumber : sortPivotIsRandomElement(less)) {
                numbers[index++] = lessNumber;
            }

            numbers[index++] = pivot;

            for (int greaterNumber: sortPivotIsRandomElement(greater)) {
                numbers[index++] = greaterNumber;
            }

            return numbers;
        }

    }

    public static void swapElements(int[] numbers, int index1, int index2) {
        int temp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = temp;
    }

    public static void sort(int[] numbers, int indexFrom, int indexTo) {
        int countElements = indexTo - indexFrom + 1;

        if (countElements == 2) {
            if (numbers[indexFrom] > numbers[indexTo]) {
                swapElements(numbers, indexFrom, indexTo);
            }

        } else if (countElements > 2) {
            int pivotIndex = Utils.getRandomInt(indexFrom, indexTo);
            int pivot = numbers[pivotIndex];

            swapElements(numbers, pivotIndex, indexTo);

            int lessIndex = indexFrom - 1;

            for (int i = indexFrom; i < indexTo; i++) {
                if (numbers[i] < pivot) {
                    swapElements(numbers, i, ++lessIndex);
                }
            }

            pivotIndex = lessIndex + 1;

            swapElements(numbers, indexTo, pivotIndex);

            sort(numbers, indexFrom, pivotIndex - 1);
            sort(numbers, pivotIndex + 1, indexTo);
        }
    }

    public static void sort(int[] numbers) {
        sort(numbers, 0, numbers.length - 1);
    }
}
