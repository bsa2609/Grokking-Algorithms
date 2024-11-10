package bsa.study.chapter3;

public class Countdown {
    public static void count(int i) {
        System.out.print(i);
        if (i > 0) {
            System.out.print("...");
            count(i - 1);

        } else {
            System.out.println("\nend of countdown");
        }
    }
}
