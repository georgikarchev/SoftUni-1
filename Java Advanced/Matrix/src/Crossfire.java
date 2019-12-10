import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] dimension = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimension[0];
        int cols = dimension[1];

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        getMatrix(matrix, rows, cols);

        String command = scanner.nextLine();

        while (!command.equals("Nuke it from orbit")) {

            int[] target = Arrays.stream(command.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int targetRow = target[0];
            int targetCol = target[1];
            int radius = target[2];

            for (int row = targetRow - radius; row <= targetRow + radius; row++) {
                if (isInside(matrix, row, targetCol)) {
                    matrix.get(row).set(targetCol, 0);
                }
            }

            for (int col = targetCol - radius; col <= targetCol + radius; col++) {
                if (isInside(matrix, targetRow, col)) {
                    matrix.get(targetRow).set(col, 0);
                }
            }

            ArrayList<Integer> toRemove = new ArrayList<>();
            toRemove.add(0);
            for (int row = 0; row < matrix.size(); row++) {
                matrix.get(row).removeAll(toRemove);

                if (matrix.get(row).size()== 0) {
                    matrix.remove(row);
                    row--;
                }
            }

            command = scanner.nextLine();
        }

        printMatrix(matrix);
    }

    private static boolean isInside(ArrayList<ArrayList<Integer>> matrix, int row, int col) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
        for (ArrayList<Integer> row : matrix){
           row.forEach(e -> System.out.print(e + " "));
           System.out.println();
        }
    }

    private static void getMatrix(ArrayList<ArrayList<Integer>> matrix, int rows, int cols) {
        int counter = 1;

        for (int row = 0; row < rows; row++){
            ArrayList<Integer> numbers = new ArrayList<>();

            for (int col = 0; col < cols; col++){
                numbers.add(counter++);
            }

            matrix.add(numbers);
        }
    }
}