import java.util.Scanner;

public class PolindromesMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        int matrixRows = Integer.parseInt(input[0]);
        int matrixCols = Integer.parseInt(input[1]);

        String element = "";

        String[][] myMatrix = new String[matrixRows][matrixCols];

        for (int row = 0; row < matrixRows; row++) {
            for (int col = 0; col < matrixCols; col++) {
                element = "" + (char)('a' + row) + (char)('a' + row + col) + (char)('a' + row);
                myMatrix[row][col] = element;
            }
        }





        printMatrix(myMatrix);
    }

    private static void printMatrix(String[][] myMatrix) {
        for (int row = 0; row < myMatrix.length; row++) {
            for (int col = 0; col < myMatrix[row].length; col++) {
                System.out.print(myMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

}
