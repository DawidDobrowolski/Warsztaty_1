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
            System.out.println("Liczba trafionych liczb: " + success);
        }else{
            System.out.println("Niestety trafiles mniej niz 3 liczby");
        }
    }


//    LOSOWANIE LICZB PRZEZ KOMPUTER
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
        System.out.println("Wylosowano nastepujace liczby: " + Arrays.toString(numbers));
        return numbers;

    }


//    WYBIERANIE LICZB PRZEZ UZYTKOWNIKA
        private static int[] userNumbers() {
        int counter = 1;
        int number = 0;
        int[] numbers = new int[6];
        while (counter < 7) {                                      //WALIDACJA LICZB
            System.out.println("prosze wprowadzic liczbe nr. : " + counter);
            number = getIntValue();
            if (number > 0 && number < 50) {
                if (numCheck(numbers, number)) {
                    System.out.println("Taka liczba juz zostala podana");
                } else {
                    numbers[counter - 1] = number;
                    counter += 1;
                }
            } else {
                System.out.println("Liczba jest spoza zakresu 1-49");
            }
        }

        Arrays.sort(numbers);
        System.out.println("Wybrales nastepujace liczby: " + Arrays.toString(numbers));
        return numbers;
    }


    //    SPRAWDZAMY CZY TAKA LICZBA JUZ WYSTAPILA
    private static boolean numCheck(int[] numberArr, int numberCheck) {
        for (int i : numberArr) {
            if (i == numberCheck) {
                return true;           //GDY WYSTAPILA
            }
        }
        return false;                 //GDY NIE WYSTAPILA
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

