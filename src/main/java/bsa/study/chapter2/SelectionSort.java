package bsa.study.chapter2;

import java.util.LinkedList;

public class SelectionSort {
    public static int[] sort(int[] numbers) {
        int[] sortedNumbers = new int[numbers.length];

        LinkedList<Integer> copiedNumbers = copyArrayToLinkedList(numbers);

        for (int i = 0; i < numbers.length; i++) {
            /*
            // code from the book
            int smallestIndex = findSmallest(copiedNumbers);
            sortedNumbers[i] = copiedNumbers.get(smallestIndex);
            copiedNumbers.remove(smallestIndex);
             */
            Integer smallest = findSmallest(copiedNumbers);
            sortedNumbers[i] = smallest;
            copiedNumbers.removeLastOccurrence(smallest);
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

    /*
    // code from the book
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
     */

    private static Integer findSmallest(LinkedList<Integer> numbers) {
        int smallest = numbers.getFirst();

        for (Integer number : numbers) {
            if (number < smallest) {
                smallest = number;
            }
        }

        return smallest;
    }
}
