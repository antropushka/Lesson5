package by.epam.lesson5.task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Lesson5 {

    /**
     * Выполнены следующие задачи: task15, task17; task22; task26; task28; task30; task31; task32; task35; task39;
     *
     * @author Tatsiana Tkachova
     */

    public static void main(String[] args) {

        task15();
        task17();
        task22();
        task26();
        task28();
        task30();
        task31();
        task32();
        task35();
        task39();

    }

        public static void task15() {
        int n = 8;
        int[][] array = new int[n][n];
        for (int i = 0; i < array.length; i++) {
            array[i][i] = n;
            n--;
        }
        printMartix(array);
    }

    public static void task17() {
        int n = 4;
        int[][] array = new int[n][n];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[0][j] = 1;
                array[n-1][j] = 1;
                array[i][0] = 1;
                array[i][n-1] = 1;
            }
        }
        printMartix(array);
    }

    public static void task22() {
        int n = 8;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j >= n - i) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = j + i + 1;
                }
            }
        }

        printMartix(matrix);
    }

    public static void task26() {
        int[][] matrix = {{1, 3, 5, 7}, {-5, 0, 3, -4}, {8, -12, -2, -9}};
        int rows = matrix.length;
        int cols = matrix[0].length;

        System.out.println("-------Initial Matrix--------");
        printMartix(matrix);
        System.out.println("--------TASK A --------");

        for (int i = 0; i < rows; i++) { //a
            int sum = 0;
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] < 0) {
                    sum += matrix[i][j];
                }
            }
            System.out.println("Sum of negative elements in the row " + i + " is " + sum + " .");
        }

        System.out.println();
        System.out.println("-------- TASK B --------");

        for (int i = 0; i < rows; i++) { //б
            int max = matrix[i][0];
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
            System.out.println("The MAX element in the row " + i + " is " + max + " .");
        }

        System.out.println();
        System.out.println("-------- TASK C --------");


        int max = matrix[0][0];
        int min = matrix[0][0];
        int maxElementRow = 0;
        int maxElementCol = 0;
        int minElementRow = 0;
        int minElementCol = 0;

        for (int i = 0; i < rows; i++) { // B
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    maxElementRow = i;
                    maxElementCol = j;
                }
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    minElementRow = i;
                    minElementCol = j;
                }
            }
        }

        matrix[maxElementRow][maxElementCol] = min;
        matrix[minElementRow][minElementCol] = max;

        printMartix(matrix);
    }


    // почему данный код работает ТОЛЬКО ДЛЯ КВАДРАТНЫХ МАТРИЦ
    public static void task28() {
        int rows = 4;
        int cols = 4;
        int[][] array = new int[rows][cols];
        int[] arrayOfSums = new int[cols];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = random.nextInt(100);
            }
        }
        printMartix(array);
        int i, j, sum = 0;
        for (i = 0; i < rows; i++) {
            for (j = 0; j < cols; j++) {
                sum = sum + array[j][i];
                arrayOfSums[i] = sum;
            }
            System.out.println("Sum of the column " + i + " = " + sum);
            sum = 0;
        }
        System.out.println(Arrays.toString(arrayOfSums));
        int maxSum = arrayOfSums[0];
        int indexOfMaxSum = 0;
        for (int k = 0; k < arrayOfSums.length; k++) {
            if (arrayOfSums[k] > maxSum) {
                maxSum = arrayOfSums[k];
                indexOfMaxSum = k;
            }
        }
        System.out.println("The column with MAX sum is " + indexOfMaxSum + " .");


    }

    public static void task30() {
        int[][] matrix = new int[10][20];
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(16);
            }
        }
        printMartix(matrix);

        int numOfRow = 0;
        for (int i = 0; i < matrix.length; i++) {
            int count = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 5) {
                    count++;
                }
            }
            if (count >= 3) {
                numOfRow++;
                if (numOfRow != 0) {
                    System.out.println("TThe number of rows in which the number 5 occurs three or more times : " + i);
                }
            }
        }
        if (numOfRow == 0) {
            System.out.println("There is NO rows in which the number 5 occurs three or more times ");
        }
    }

    public static void task31() {
        int[][] array = new int[4][4];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(1000);
            }
        }
        printMartix(array);
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] >=10 && array[i][j] <= 99) {
                    count++;
                }
            }
        }
        if (count != 0 && count != 1) {
            System.out.println("There  ARE " + count + " two-digit numbers in the matrix.");
        } else if (count == 1) {
            System.out.println("There  IS " + count +" two-digit number in the matrix.");
        } else {
            System.out.println("There  is NO two-digit numbers in the matrix.");
        }

    }

    public static void task32() {
        int[][] array = new int[4][4];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(100);
            }
        }
        System.out.println("Initial Matrix");
        printMartix(array);
        System.out.println("Matrix rows sorted in ascending order of element values");
        sortRowWiseIncrease(array);
        printMartix(array);
        System.out.println("Matrix rows sorted in descending order of element values");
        sortRowWiseDecrease(array);
        printMartix(array);
    }

    public static void task35() {
        int[][] array = new int[4][4];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(100);
            }
        }
        printMartix(array);
        int max = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] % 2 != 0) {
                    array[i][j] = max;

                }
            }
        }
        System.out.println(max);
        printMartix(array);
    }

    public static void task39() {
        int rows1 = 2;
        int cols1 = 4;
        int rows2 = 4;
        int cols2 = 10;
        int[][] matrix1 = new int[rows1][cols1];
        int[][] matrix2 = new int[rows2][cols2];
        Random random = new Random();

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                matrix1[i][j] = random.nextInt(10);
            }
        }
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                matrix2[i][j] = random.nextInt(10);
            }
        }
        System.out.println("MATRIX ONE");
        printMartix(matrix1);
        System.out.println("MATRIX TWO");
        printMartix(matrix2);

        if (rows2 != cols1) {
            System.out.println(" Multiplication Is Not Possible ");
        } else {
            int[][] multiplicationOfMatrixResult = new int[rows1][cols2];
            for (int i = 0; i < rows1; i++) {
                for (int j = 0; j < cols2; j++) {
                    for (int k = 0; k < rows2; k++)
                        multiplicationOfMatrixResult[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
            System.out.println("RESULT OF MATRIX MULTIPLICATION ");
            printMartix(multiplicationOfMatrixResult);
        }
    }


    public static void printMartix(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("[%4d]", array[i][j]);
            }
            System.out.println();
        }
        System.out.println();

    }

    public static void  sortRowWiseIncrease(int[][] array) {
        boolean sorted = false;
        int temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    for (int k = 0; k < array[i].length - j - 1; k++) {
                        if (array[i][k] > array[i][k + 1]) {
                            temp = array[i][k];
                            array[i][k] = array[i][k + 1];
                            array[i][k + 1] = temp;
                            sorted = false;
                        }
                    }
                }
            }
        }
    }
    public static void  sortRowWiseDecrease(int[][] array) {
        boolean sorted = false;
        int temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    for (int k = 0; k < array[i].length - j - 1; k++) {
                        if (array[i][k] < array[i][k + 1]) {
                            temp = array[i][k];
                            array[i][k] = array[i][k + 1];
                            array[i][k + 1] = temp;
                            sorted = false;
                        }
                    }
                }
            }
        }
    }
}
