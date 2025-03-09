package bsa.study;

import bsa.study.chapter1.BinarySearch;
import bsa.study.chapter2.SelectionSort;
import bsa.study.chapter3.BinarySearchRecursively;
import bsa.study.chapter3.Countdown;
import bsa.study.chapter3.Factorial;
import bsa.study.chapter3.MaxElementOfArray;
import bsa.study.chapter4.QuickSort;
import bsa.study.chapter3.SumOfElementsOfArray;
import bsa.study.chapter5.HashTable;
import bsa.study.chapter6.BreadthFirstSearch;
import bsa.study.chapter6.Graph.Graph;
import bsa.study.chapter6.Graph.Node;

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
        int number2v1 = 5;
        System.out.printf("Index of %d in array is %d%n",
                number2v1, BinarySearch.find(numbers2, number2v1));

        int number2v2 = 15;
        System.out.printf("Index of %d in array is %d%n",
                number2v2, BinarySearch.find(numbers2, number2v2));

        int[] numbers3 = new int[]{1};
        int number3v1 = 1;
        System.out.printf("Index of %d in array is %d%n",
                number3v1, BinarySearch.find(numbers3, number3v1));

        int number3v2 = 2;
        System.out.printf("Index of %d in array is %d%n",
                number3v2, BinarySearch.find(numbers3, number3v2));
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
        System.out.printf("Calculate factorial: %d%n", i);
        System.out.println(Factorial.calculate(i));

        int[] numbers1 = Utils.getArrayWithRandomInt(5, 1, 10);
        System.out.printf("Calculate sum of elements of array: %s%n", Arrays.toString(numbers1));
        System.out.println(SumOfElementsOfArray.calculate(numbers1));

        int[] numbers2 = Utils.getArrayWithRandomInt(15, 1, 50);
        System.out.printf("Find maximum element of array: %s%n", Arrays.toString(numbers2));
        System.out.println(MaxElementOfArray.find(numbers2));

        int[] numbers3 = SelectionSort.sort(Utils.getArrayWithRandomInt(15, 1, 50));
        int item = Utils.getRandomInt(1, 50);
        System.out.printf("Index of %d in array %s%n", item, Arrays.toString(numbers3));
        System.out.println(BinarySearchRecursively.findUsingSubArrays(numbers3, item));
        System.out.println(BinarySearchRecursively.findUsingIndexes(numbers3, item));
    }

    public static void chapter4() {
        System.out.println("Chapter 4");

        // Quick sort
        System.out.println("Quick sort");
        int[] numbers4 = Utils.getArrayWithRandomInt(20, 1, 50);
        System.out.printf("Unsorted array: %s%n", Arrays.toString(numbers4));
        System.out.printf("Sorted array (pivot is first element): %s%n",
                Arrays.toString(QuickSort.sortPivotIsFirstElement(numbers4)));
        System.out.printf("Sorted array (pivot is random element): %s%n",
                Arrays.toString(QuickSort.sortPivotIsRandomElement(numbers4)));

        System.out.println("Quick sort without sub arrays");
        int[] numbers5 = Utils.getArrayWithRandomInt(30, 1, 100);
        System.out.printf("Unsorted array: %s%n", Arrays.toString(numbers5));
        QuickSort.sort(numbers5);
        System.out.printf("Sorted array: %s%n", Arrays.toString(numbers5));
    }

    public static void chapter5() {
        System.out.println("Chapter 5");

        // hash table
        System.out.println("Hash table");

        HashTable hashTable = new HashTable();
        System.out.printf("size = %s%n", hashTable.size());
        System.out.printf("hash table: %s%n", hashTable.toString());

        hashTable.put("apple", 10);
        System.out.printf("size = %s%n", hashTable.size());
        System.out.printf("hash table: %s%n", hashTable.toString());

        hashTable.put("banana", 12);
        hashTable.put("tomato", 8);
        hashTable.put("potato", 5);
        hashTable.put("strawberry", 11);
        hashTable.put("orange", 9);
        hashTable.put("plum", 7);
        hashTable.put("cherry", 14);

        System.out.printf("size = %s%n", hashTable.size());
        System.out.printf("hash table: %s%n", hashTable.toString());
        System.out.printf("plum = %s%n", hashTable.get("plum"));
        System.out.printf("cherry = %s%n", hashTable.get("cherry"));

        hashTable.put("plum", 16);
        hashTable.put("cherry", 17);

        System.out.printf("size = %s%n", hashTable.size());
        System.out.printf("hash table: %s%n", hashTable.toString());
        System.out.printf("plum = %s%n", hashTable.get("plum"));
        System.out.printf("cherry = %s%n", hashTable.get("cherry"));

        hashTable.delete("orange");

        System.out.printf("size = %s%n", hashTable.size());
        System.out.printf("hash table: %s%n", hashTable.toString());
    }

    public static void chapter6() {
        System.out.println("Chapter 6");

        // Queue
        /*
        System.out.println("Queue");

        Queue<String> queue = new Queue<>();
        System.out.println("is empty: " + queue.isEmpty());
        System.out.println(queue);

        queue.put("one");
        System.out.println("is empty: " + queue.isEmpty());
        System.out.println(queue);

        queue.put("two");
        queue.put("three");
        System.out.println(queue);

        System.out.println("pop: " + queue.pop());
        System.out.println(queue);

        queue.put("four");
        System.out.println(queue);

        System.out.println("pop: " + queue.pop());
        System.out.println(queue);
        System.out.println("pop: " + queue.pop());
        System.out.println("pop: " + queue.pop());
        System.out.println("is empty: " + queue.isEmpty());
        System.out.println(queue);
         */

        //BreadthFirstSearch
        try {
            Graph<String> graph = new Graph<>("I", false);
            graph.addNode("Bob", false);
            graph.addNode("Alice", false);
            graph.addNode("Clare", false);

            graph.addEdge("I", "Bob");
            graph.addEdge("I", "Alice");
            graph.addEdge("I", "Clare");

            graph.addNode("Anudge", false);

            graph.addEdge("Bob", "Anudge");

            graph.addNode("Peggi", true);

            graph.addEdge("Bob", "Peggi");
            graph.addEdge("Alice", "Peggi");

            graph.addNode("Tom", false);
            graph.addNode("Johnny", false);

            graph.addEdge("Clare", "Tom");
            graph.addEdge("Clare", "Johnny");

            graph.addNode("Piter", true);

            graph.addEdge("Johnny", "Piter");

            Node<String> nearestSeller = BreadthFirstSearch.findNearestSeller(graph);

            if (nearestSeller == null) {
                System.out.println("Seller not found");
            } else {
                System.out.println("Seller is " + nearestSeller.getValue());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
