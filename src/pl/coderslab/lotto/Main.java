package pl.coderslab.lotto;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int success = 0;
        int[] userNum = userNumbers();
        int[] lottoNum = lottoNumbers();
        for (int i :userNum){
            for(int j : lottoNum){
                if(i == j){
                    success +=1;
                }
            }
        }
        if (success>2) {
            System.out.println("Number of hit numbers: " + success);
        }else{
            System.out.println("Unfortunately, you hit less than 3 numbers");
        }
    }


//    RANDOM NUMBER BY A COMPUTER
    private static int[] lottoNumbers() {
        Random r = new Random();
        int counter = 1;
        int los = 0;
        int[] numbers = new int[6];
        while(counter<7) {
            los = r.nextInt(100) + 1;
            if (los > 0 && los < 50){
                if (!numCheck(numbers,los)){
                    numbers[counter - 1] = los;
                    counter += 1;
                }
            }
        }
        Arrays.sort(numbers);
        System.out.println("Lottery numbers are as follows: " + Arrays.toString(numbers));
        return numbers;

    }


//    CHOOSING NUMBERS BY THE USER
        private static int[] userNumbers() {
        int counter = 1;
        int number = 0;
        int[] numbers = new int[6];
        while (counter < 7) {                                      //NUMBER VALIDATION
            System.out.println("Please enter the number No. " + counter);
            number = getIntValue();
            if (number > 0 && number < 50) {
                if (numCheck(numbers, number)) {
                    System.out.println("This number has already been given");
                } else {
                    numbers[counter - 1] = number;
                    counter += 1;
                }
            } else {
                System.out.println("The number is out of the range 1-49");
            }
        }

        Arrays.sort(numbers);
        System.out.println("You have selected the following numbers: " + Arrays.toString(numbers));
        return numbers;
    }


    //    CHECK WHETHER SUCH NUMBER HAS ALREADY OCCURRED
    private static boolean numCheck(int[] numberArr, int numberCheck) {
        for (int i : numberArr) {
            if (i == numberCheck) {
                return true;           //IF OCCURRED
            }
        }
        return false;                 //IF NOT OCCURRED
    }




    //    WPISANIE LICZBY DO TERMINALA PRZEZ UZYTKOWNIKA
    private static int getIntValue() {
        Scanner scan = new Scanner(System.in);

        while (!scan.hasNextInt()) {
            System.out.println("Prosze wprowadzic liczbe");
            scan.nextLine();
        }

        return scan.nextInt();
    }
}

