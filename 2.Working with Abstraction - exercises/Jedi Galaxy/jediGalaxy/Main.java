package jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = getCoordinates(scanner.nextLine());

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = createGalaxy(rows, cols);

        String command = scanner.nextLine();

        long starsValue = 0;

        while (!command.equals("Let the Force be with you")) {

            int[] jediCoordinates = getCoordinates(command);
            int[] evilCoordinates = getCoordinates(scanner.nextLine());

            int evilRow = evilCoordinates[0];
            int evilCol = evilCoordinates[1];

            while (evilRow >= 0 && evilCol >= 0) {
                if (isInBounds(matrix, evilRow, evilCol)) {
                    matrix[evilRow][evilCol] = 0;
                }
                evilRow--;
                evilCol--;
            }

            int jediRow = jediCoordinates[0];
            int jediCol = jediCoordinates[1];

            while (jediRow >= 0 && jediCol < matrix[1].length) {
                if (isInBounds(matrix, jediRow, jediCol)) {
                    starsValue += matrix[jediRow][jediCol];
                }
                jediCol++;
                jediRow--;
            }

            command = scanner.nextLine();
        }

        System.out.println(starsValue);

    }

    private static boolean isInBounds(int[][] matrix, int row, int col) {
        return (row >= 0 && col >= 0 && row < matrix.length && col < matrix[row].length);
    }

    private static int[][] createGalaxy(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        int value = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = value++;
            }
        }
        return matrix;
    }

    private static int[] getCoordinates(String command) {
        return Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
