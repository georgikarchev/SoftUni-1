import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] myMatrix = new int[rows][cols];

        fillMatrix(myMatrix, scanner);

        int maxSum = Integer.MIN_VALUE;
        int biggestMatrixRow = 0;
        int biggestMatrixCol = 0;

        for (int row = 0; row < myMatrix.length - 2; row++) {
            for (int col = 0; col < myMatrix[row].length - 2; col++) {
                int currentSum = getCurrentSumOfMatrix(myMatrix, row, col);

                if (currentSum > maxSum){
                    maxSum = currentSum;
                    biggestMatrixRow = row;
                    biggestMatrixCol = col;
                }
            }
        }

        printOutput(maxSum, biggestMatrixRow, biggestMatrixCol, myMatrix);

    }

    private static void printOutput(int maxSum, int biggestMatrixRow, int biggestMatrixCol, int[][] matrix) {
        System.out.printf("Sum = %d%n", maxSum);

        for (int row = biggestMatrixRow; row < biggestMatrixRow + 3; row++) {
            for (int col = biggestMatrixCol; col < biggestMatrixCol + 3 ; col++) {
                System.out.print(matrix[row][col] + " ");
            }

            System.out.println();
        }
    }

    private static int getCurrentSumOfMatrix(int[][] matrix, int row, int col) {
        int currentSum = 0;
        for (int i = row; i < row + 3 ; i++) {
            for (int j = col; j < col + 3 ; j++) {
                currentSum += matrix[i][j];
            }
        }

        return currentSum;
    }

    private static void fillMatrix(int[][] myMatrix, Scanner scanner) {
        for (int row = 0; row < myMatrix.length; row++) {
            myMatrix[row] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
    }
}