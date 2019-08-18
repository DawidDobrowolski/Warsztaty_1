package pl.coderslab.guessNumber;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//       COMPUTER CHOOSES NUMBER
        Random r = new Random();
        int los = r.nextInt(100) +1 ;
        int guess = 0;

//       PLAYER GUESS NUMBER
        while(true){
            System.out.print("Guess the number: ");
            guess = getIntValue();
            if (guess < los){
                System.out.println("Too low!");
            }else if(guess > los){
                System.out.println("Too high!");
            }else{
                System.out.println("Correct!");
                break;
            }

        }


    }
    private static int getIntValue() {
        Scanner scan = new Scanner(System.in);

        while (!scan.hasNextInt()) {
            System.out.println("Please enter the number");
            scan.nextLine();
        }
        return scan.nextInt();
    }
}
