package KompProg.lab4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public class Lab4 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n;
        int[] scores;

        try {
            n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            if (n == 0){
                System.err.println("Error, n cannot be zero.");
                return;
            }

            scores = new int[n];

            String[] scoresItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int scoresItem = Integer.parseInt(scoresItems[i]);
                scores[i] = scoresItem;
            }
        }catch(Exception ex){
            System.err.println("Input error.");
            return;
        }

        OOP oop = new OOP();

        Callable<int[]> task = () -> {oop.setResult(oop.breakingRecords(scores)); return oop.getResult();};
        Executors.newCachedThreadPool().submit(task);

        new Thread(() -> {
            oop.setResult(oop.breakingRecords(scores));
            System.out.println("Side thread");
            for (int i = 0; i < oop.getResult().length; i++) {
                //bufferedWriter.write(String.valueOf(result[i]));
                System.out.println(String.valueOf(oop.getResult()[i]));

                if (i != oop.getResult().length - 1) {
                    //bufferedWriter.write(" ");
                }
            }

        }).start();
        int[] result = oop.getResult();

        System.out.println("Main thread");
        for (int i = 0; i < result.length; i++) {
            //bufferedWriter.write(String.valueOf(result[i]));
            System.out.println(String.valueOf(result[i]));

            if (i != result.length - 1) {
                //bufferedWriter.write(" ");
            }
        }

//        bufferedWriter.newLine();
//        bufferedWriter.close();
        scanner.close();
    }
}
