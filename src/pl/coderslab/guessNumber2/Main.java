package pl.coderslab.guessNumber2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Think the number from 0 to 1000 and I will guess it in max 10 attempts");
        int min = 0;
        int max = 1000;
        int result = 0;
        int count = 1;


        while (true) {            // LOOP WORKING AS LONG AS THE NUMBER IS GUESSED
            int guess = (max - min) / 2 + min;
            System.out.println("Attempt " + count + " I'm guessing: " + guess);
            System.out.println("Did i guess? (1 - YES, 2 - NO)");
            result = getIntValue();
            if (result != 1) {
                System.out.print("Is your number higher ? (1 - YES, 2 - NO)");
                result = getIntValue();
                if (result == 1) {
                    min = guess;
                } else {
                    System.out.println("Is your number lower ? (1 - YES, 2 - NO)");
                    result = getIntValue();
                    if (result == 1) {
                        max = guess;
                    } else {
                        System.out.println("Do not cheat!");
                    }
                }
            }else{
                System.out.println("I WON!");
                break;
            }
            count += 1;
        }

    }


//        GETTING VALUE FROM A USER + CHECK IF IT IS ALLOWED VALUE (1 OR 2)
    private static int getIntValue() {
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        while (true) {
            while (!scan.hasNextInt()) {
                System.out.println("Value other than 1 or 2");
                scan.nextLine();
            }
            choice = scan.nextInt();
            if (choice > 0 && choice < 3) {
                break;
            }
        }
        return choice;
    }
}
