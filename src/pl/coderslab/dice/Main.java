package pl.coderslab.dice;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(diceThrow(throwCode())));


    }


    //     DICE THROWS IN LINE WITH THE GIVEN FORMULA
    private static int[] diceThrow(int[] param) {
        int dice = 0;
        int[] simulation = new int[param[0]];
        Random r = new Random();
        for (int i = 0; i < param[0]; i++) {
            dice = r.nextInt(param[1]) + 1;
            simulation[i] = dice + param[2];
        }
        return simulation;
    }


    //    INPUT THROW FORMULA AND CHECK FOR CORRECTNESS
    private static int[] throwCode() {
        int[] marks = new int[3];
        String code = "";
        String[] codeArr = new String[2];
        boolean ifZ;
        boolean ifX;
        String markZ = "";
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter formula for dice throw simulation");


        while (true) {
            code = scan.nextLine();
            code = code.toLowerCase();

//            WE CHECK IF THERE IS A NUMBER BEFORE D
            if (code.indexOf("d") > 0) {
                ifX = true;
            } else if (code.indexOf("d") == 0) {
                ifX = false;
            } else {
                System.out.println("Given formula has mistakes, try again.");
                continue;
            }

//            WE CHECK IF THERE IS CHAR AFTER D
            if (code.indexOf("d")+1 == code.length()) {
                System.out.println("Given formula has mistakes, try again.");
                continue;
            }

//            WE CHECK IF Z VARIABLE EXIST
            if (code.indexOf('+') > 0) {
                ifZ = true;
                markZ = "+";
            } else if (code.indexOf('-') > 0) {
                ifZ = true;
                markZ = "-";
            } else {
                ifZ = false;
            }

            // CHECK ALL CASES OF FORMULA + ERROR LOCKING

            if (ifX && ifZ) {
                codeArr = code.split("d");
                String[] codeArr2 = new String[2];
                codeArr2 = codeArr[1].split("[" + markZ + "]");
                try {
                    marks[0] = Integer.parseInt(codeArr[0]);
                    marks[1] = Integer.parseInt(codeArr2[0]);
                    marks[2] = Integer.parseInt(markZ + codeArr2[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Given formula has mistakes, try again.");
                    continue;
                }
                break;

            } else if (ifX && !ifZ) {
                codeArr = code.split("d");
                try {
                    marks[0] = Integer.parseInt(codeArr[0]);
                    marks[1] = Integer.parseInt(codeArr[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Given formula has mistakes, try again.");
                    continue;
                }
                marks[2] = 0;
                break;
            } else if (!ifX && ifZ) {
                code = code.replaceFirst("d", "");
                codeArr = code.split("[" + markZ + "]");
                marks[0] = 1;
                try {
                    marks[1] = Integer.parseInt(codeArr[0]);
                    marks[2] = Integer.parseInt(markZ + codeArr[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Given formula has mistakes, try again.");
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
                    System.out.println("Given formula has mistakes, try again.");
                    continue;
                }
                break;
            }

        }
        return marks;
    }
}
