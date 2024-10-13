package app;

import java.util.Random;

public class hw09 {

    public static void main(String[] args) {

        int[][] matrix = new int[4][4];
        Random rand = new Random();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = rand.nextInt(50) + 1;
            }
        }
        System.out.println("Матриця 4x4:");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        int sumEvenRows = 0, sumOddRows = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i % 2 == 0) {
                    sumEvenRows += matrix[i][j];
                } else {
                    sumOddRows += matrix[i][j];
                }
            }
        }
        long productEvenCols = 1, productOddCols = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j % 2 == 0) {
                    productEvenCols *= matrix[i][j];
                } else {
                    productOddCols *= matrix[i][j];
                }
            }
        }
        System.out.println("\nСума елементів у парних рядках (рядок 0, 2): " + sumEvenRows);
        System.out.println("Сума елементів у непарних рядках (рядок 1, 3): " + sumOddRows);
        System.out.println("Добуток елементів у парних стовпцях (стовпець 0, 2): " + productEvenCols);
        System.out.println("Добуток елементів у непарних стовпцях (стовпець 1, 3): " + productOddCols);

        if (isMagicSquare(matrix)) {
            System.out.println("\nМатриця є магічним квадратом.");
        } else {
            System.out.println("\nМатриця не є магічним квадратом.");
        }
    }
    public static boolean isMagicSquare(int[][] matrix) {
        int magicSum = 0;

        for (int j = 0; j < 4; j++) {
            magicSum += matrix[0][j];
        }

        for (int i = 1; i < 4; i++) {
            int rowSum = 0;
            for (int j = 0; j < 4; j++) {
                rowSum += matrix[i][j];
            }
            if (rowSum != magicSum) {
                return false;
            }
        }

        for (int j = 0; j < 4; j++) {
            int colSum = 0;
            for (int i = 0; i < 4; i++) {
                colSum += matrix[i][j];
            }
            if (colSum != magicSum) {
                return false;
            }
        }

        int diag1Sum = 0, diag2Sum = 0;
        for (int i = 0; i < 4; i++) {
            diag1Sum += matrix[i][i];
            diag2Sum += matrix[i][3 - i];
        }
        return diag1Sum == magicSum && diag2Sum == magicSum;
    }
}

