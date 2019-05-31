package pl.coderslab.dice;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

         // System.out.println(Arrays.toString(throwCode()));
        System.out.println(Arrays.toString(diceThrow(throwCode())));


    }


//     RZUTY KOSTKA ZGODNIE Z PODANYM KODEM
    private static int[] diceThrow(int[] param) {
        int dice = 0;
        int[] simulation = new int[param[0]];
        Random r = new Random();
        for (int i = 0; i < param[0]; i++) {
            dice = r.nextInt(param[1])+1;
            simulation[i] = dice +param[2];
        }
        return simulation;
    }


    //    WPROWADZANIE I SPRAWDZANIE POPRAWNOSCI KODU
    private static int[] throwCode() {
        int[] marks = new int[3];
        String code = "";
        String[] codeArr = new String[2];
        boolean ifZ;
        boolean ifX;
        String markZ = "";
        Scanner scan = new Scanner(System.in);
        System.out.println("Prosze podaj kod rzutu kostka do gry");


        while (true) {
            code = scan.nextLine();
            code = code.toLowerCase();

//            SPRAWDZAMY CZY JEST JAKAS LICZBA PRZED D
            if (code.indexOf("d") > 0) {
                ifX = true;
            } else if (code.indexOf("d") == 0) {
                ifX = false;
            } else {
                System.out.println("Wprowadzono zly kod kostki do gry. Sprobuj jeszcze raz.");
                continue;
            }

//            SPRAWDZAMY CZY ISTNIEJE SKLADNIK Z
            if (code.indexOf('+') > 0) {
                ifZ = true;
                markZ = "+";
            } else if (code.indexOf('-') > 0) {
                ifZ = true;
                markZ = "-";
            } else {
                ifZ = false;
            }

            // SPRAWDZAMY PRZYPADKI WPISANIA KODU + WYLAPANIE BLEDOW

            if (ifX && ifZ) {
                codeArr = code.split("d");
                String[] codeArr2 = new String[2];
                codeArr2 = codeArr[1].split("[" + markZ+ "]");
                try {
                    marks[0] = Integer.parseInt(codeArr[0]);
                    marks[1] = Integer.parseInt(codeArr2[0]);
                    marks[2] = Integer.parseInt(markZ + codeArr2[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Wprowadzono zly kod kostki do gry. Sprobuj jeszcze raz.");
                    continue;
                }
                break;

            } else if (ifX && !ifZ) {
                codeArr = code.split("d");
                try {
                    marks[0] = Integer.parseInt(codeArr[0]);
                    marks[1] = Integer.parseInt(codeArr[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Wprowadzono zly kod kostki do gry. Sprobuj jeszcze raz.");
                    continue;
                }
                marks[2] = 0;
                break;
            } else if (!ifX && ifZ) {
                code = code.replaceFirst("d", "");
                codeArr = code.split("[" + markZ+ "]");
                marks[0] = 1;
                try {
                    marks[1] = Integer.parseInt(codeArr[0]);
                    marks[2] = Integer.parseInt(markZ + codeArr[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Wprowadzono zly kod kostki do gry. Sprobuj jeszcze raz.");
                    continue;
                }
                break;

            } else if (!ifX && !ifZ) {
                code = code.replaceFirst("d", "");
                marks[0] = 1;
                marks[2] = 0;
                try {
                    marks[1] = Integer.parseInt(code);
                } catch (NumberFormatException e) {
                    System.out.println("Wprowadzono zly kod kostki do gry. Sprobuj jeszcze raz.");
                    continue;
                }
                break;
            }

        }
        return marks;
    }
}
