import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {

    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int row = dimensions[0], col = dimensions[1];

        matrix = new int[row][col];

        for (int i = 0; i < row; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        col--;
		row--;

        while (row != -1){
            int r = row, c = col;
            while (!isInbounds(r, c)){
                System.out.print(matrix[r--][c++] + " ");
            }
            System.out.println();
            col--;
            if(col < 0){
                col = 0;
                row--;
            }
        }
    }

    private static boolean isInbounds(int row, int col) {
        return row < 0 || col < 0 || row > matrix.length - 1 || col > matrix[0].length - 1;
    }
}