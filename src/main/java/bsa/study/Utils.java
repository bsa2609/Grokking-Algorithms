package bsa.study;

public class Utils {
    public static int getRandomInt(int min, int max) {
        return min + (int) Math.round(Math.random() * (max - min));
    }

    public static int[] getArrayWithRandomInt(int arrayLength, int minNumber, int maxNumber) {
        int[] numbers = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            numbers[i] = getRandomInt(minNumber, maxNumber);
        }

        return numbers;
    }

    public static int[] getSubArray(int[] numbers, int indexFromInclude, int indexToExclude) {
        int newLength = indexToExclude - indexFromInclude;
        int[] newNumbers = new int[newLength];

        for (int i = 0; i < newLength; i++) {
            newNumbers[i] = numbers[indexFromInclude + i];
        }

        return newNumbers;
    }
}
