package pl.coderslab.pl.coderslab.guessNumber2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Pomysl liczbe od 0 do 1000 a ja ja zgadne w max 10 probach");
        int min = 0;
        int max = 1000;
        int result = 0;
        int count = 1;


        while (true) {            // PETLA DZIALAJACA DOPOKI KOMPUTER ZGADNIE LICZBE
            int guess = (max - min) / 2 + min;
            System.out.println("Ruch " + count + " Zgaduje: " + guess);
            System.out.println("Czy zgadlem? (1 - tak, 2 - nie)");
            result = getIntValue();
            if (result != 1) {
                System.out.print("Czy twoja liczba jest wieksza ? (1 - tak, 2 - nie)");
                result = getIntValue();
                if (result == 1) {
                    min = guess;
                } else {
                    System.out.println("Czy twoja liczba jest mniejsza ? (1 - tak, 2 - nie)");
                    result = getIntValue();
                    if (result == 1) {
                        max = guess;
                    } else {
                        System.out.println("Nie szukuj!");
                    }
                }
            }else{
                System.out.println("WYGRALEM!");
                break;
            }
            count += 1;
        }

    }


//        POBIERANIE WARTOSCI OD UZYTKOWNIKA ZE SPRAWDZENIEM CZY TO 1 LUB 2
    private static int getIntValue() {
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        while (true) {
            while (!scan.hasNextInt()) {
                System.out.println("Wybrano wartosc inna niz 1 lub 2");
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
