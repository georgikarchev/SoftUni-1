import java.util.Arrays;
import java.util.Scanner;

public class MatrixDiogonalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixSize = Integer.parseInt(scanner.nextLine());

        int[][] myMatrix = new int[matrixSize][matrixSize];
        int firstDiogonalsum = 0;
        int secondDiogonalsum = 0;

        for (int row = 0; row < matrixSize; row++) {
            myMatrix[row] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        for (int counter = 0; counter < matrixSize ; counter++) {
            firstDiogonalsum+= myMatrix[counter][counter];
            secondDiogonalsum+= myMatrix[counter][matrixSize-1-counter];
        }
        int difference = Math.abs(firstDiogonalsum - secondDiogonalsum);

        System.out.print(difference);
    }


}
