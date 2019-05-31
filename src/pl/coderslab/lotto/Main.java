package pl.coderslab.lotto;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int counter = 1;
        int[] numbers = new int[6];
        int number = 0;

        while (counter < 7) {
            System.out.println("prosze wprowadzic liczbe nr. : " + counter);
            number = getIntValue();
            if (number > 0 && number < 50) {
                numbers[counter - 1] = number;
                counter +=1;
            }
        }
        System.out.println(Arrays.toString(numbers));

    }

    private static int getIntValue() {
        Scanner scan = new Scanner(System.in);

        while (!scan.hasNextInt()) {
            System.out.println("Prosze wprowadzic liczbe");
            scan.nextLine();
        }

        return scan.nextInt();
    }
}

