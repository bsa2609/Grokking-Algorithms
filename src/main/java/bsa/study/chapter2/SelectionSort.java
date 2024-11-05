package bsa.study.chapter2;

import java.util.LinkedList;

public class SelectionSort {
    public static int[] sort(int[] numbers) {
        int[] sortedNumbers = new int[numbers.length];

        LinkedList<Integer> copiedNumbers = copyArrayToLinkedList(numbers);

        for (int i = 0; i < numbers.length; i++) {
            int smallestIndex = findSmallest(copiedNumbers);
            sortedNumbers[i] = copiedNumbers.get(smallestIndex);
            copiedNumbers.remove(smallestIndex);
        }

        return sortedNumbers;
    }

    private static LinkedList<Integer> copyArrayToLinkedList(int[] numbers) {
        LinkedList<Integer> copiedNumbers = new LinkedList<>();

        for (int number : numbers) {
            copiedNumbers.add(number);
        }

        return copiedNumbers;
    }

    private static int findSmallest(LinkedList<Integer> numbers) {
        int smallest = numbers.getFirst();
        int smallestIndex = 0;

        int i = 0;
        for (Integer number : numbers) {
            if (number < smallest) {
                smallest = number;
                smallestIndex = i;
            }
            i++;
        }

        return smallestIndex;
    }
}
