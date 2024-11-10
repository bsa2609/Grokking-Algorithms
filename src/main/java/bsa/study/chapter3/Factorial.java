package bsa.study.chapter3;

public class Factorial {
    public static int calculate(int i) {
        if (i == 1) {
            return 1;
        } else {
            return i * calculate(i - 1);
        }
    }
}
