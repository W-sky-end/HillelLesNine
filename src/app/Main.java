package app;

import java.util.Random;

public class Main {
    static int[][] number;
    static int sumNonNumbers;
    static int sumEvenNumbers;
    static long evenMultiplication = 1;
    static long nonEvenMultiplication = 1;

    public static void main(String[] args) {
        number = new int[4][4];
        Random random = new Random();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                number[i][j] = random.nextInt(1, 51);
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(number[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("#########");

        for (int i = 0; i < number.length; i += 2) {
            for (int j = 0; j < number[i].length; j++) {
                sumNonNumbers += number[i][j];
            }
        }
        System.out.println("Sum of elements in even lines : " + sumNonNumbers + " range is : \"0,2\"");
        for (int i = 1; i < number.length; i += 2) {
            for (int j = 0; j < number[i].length; j++) {
                sumEvenNumbers += number[i][j];
            }
        }

        System.out.println("Sum of elements in non-odd rows: " + sumEvenNumbers +
                " range is : \"1,3\"" + "\n######### ");
        evenMultiplication = 1;
        for (int j = 0; j < number[0].length; j += 2) {
            for (int i = 0; i < number.length; i++) {
                evenMultiplication *= number[i][j];
            }
        }
        System.out.print("Multiplication of \"0,2\" pillar is : " + evenMultiplication + "\n");
        nonEvenMultiplication = 1;
        for (int j = 1; j < number[0].length; j += 2) {
            for (int i = 0; i < number.length; i++) {
                nonEvenMultiplication *= number[i][j];
            }
        }
        System.out.print("Multiplication of \"1,3\" pillar is : " + nonEvenMultiplication  + "\n#########\n");
        if (magicSquad(number)) {
            System.out.println("its magic quad");
        } else {
            System.out.println("nope, its not a magic quad.");
        }
    }



    public static boolean magicSquad(int[][] square) {
        int a = square.length;
        int magSum = 0;

        for (int j = 0; j < a; j++) {
            magSum += square[0][j];
        }

        for (int i = 1; i < a; i++) {
            int rSum = 0;
            for (int j = 0; j < a; j++) {
                rSum += square[i][j];
            }
            if (rSum != magSum) {
                return false;
            }
        }

        for (int j = 0; j < a; j++) {
            int cSum = 0;
            for (int i = 0; i < a; i++) {
                cSum += square[i][j];
            }
            if (cSum != magSum) {
                return false;
            }
        }

        int dSum = 0;
        for (int i = 0; i < a; i++) {
            dSum += square[i][i];
        }
        if (dSum != magSum) {
            return false;
        }

        int dSum2 = 0;
        for (int i = 0; i < a; i++) {
            dSum2 += square[i][a - i - 1];
        }
        if (dSum2 != magSum) {
            return false;
        }

        return true;
    }
}

