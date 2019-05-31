package pl.coderslab.guessNumber;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        KOMPUTER LOSUJE LICZBE
        Random r = new Random();
        int los = r.nextInt(100) +1 ;
        int guess = 0;

//        UZYWKONIK ZGADUJE LICZBE
        while(true){
            System.out.println("Zgadnij liczbe");
            guess = getIntValue();
            if (guess < los){
                System.out.println("Za malo");
            }else if(guess > los){
                System.out.println("Za duzo");
            }else{
                System.out.println("Zgadles");
                break;
            }

        }


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
