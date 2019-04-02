package cz.czechitas.angrybirds.engine.util;

import java.text.*;

public class Benchmark {

    public static void measureTime(Runnable code) {
        int repeatCount = 200;
        for (int i = 0; i < repeatCount; i++) {
            code.run();
            System.out.print(".");
        }
        long startTime = System.nanoTime();
        for (int i = 0; i < repeatCount; i++) {
            code.run();
            System.out.print(".");
        }
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(MessageFormat.format("Total time: {0,number,#,##0.000000}", totalTime * 1.0 / repeatCount / 1000_000_000.0));
        System.exit(0);
    }

    public static void showTime(String methodName, Runnable code) {
        long startTime = System.nanoTime();
        code.run();
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(MessageFormat.format("Total time for {0}: {1,number,#,##0.000000}", methodName, totalTime * 1.0 / 1000_000_000.0));

    }

}
