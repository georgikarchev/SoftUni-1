import com.sun.source.tree.WhileLoopTree;

import java.util.Scanner;

public class ExelFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer rowCount = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[rowCount][];
      //  String[][] matrixToPrint;   TO DO: when you have time

        for (int i = 0; i <rowCount ; i++) {
            matrix[i] = scanner.nextLine().split(", ");
        }

        String[] commands = scanner.nextLine().split(" ");

        if (commands[0].equals("hide")){
            hideOperation(matrix, commands[1]);
        }else if(commands[0].equals("sort")){
            sortOperation(matrix, commands[1]);
        }else{
            filterOperation(matrix, commands[1], commands[2]);
        }
    }

    private static void filterOperation(String[][] matrix, String filterCol, String value) {
        int filterIndex = getHiddenIndex(matrix[0], filterCol);

        System.out.println(String.join(" | ", matrix[0]));
        for (int row = 1; row < matrix.length; row++) {
            if (matrix[row][filterIndex].equals(value)) {
                System.out.println(String.join(" | ", matrix[row]));
            }
        }
    }

    private static void sortOperation(String[][] matrix, String command) {
        int sortIndex = getHiddenIndex(matrix[0], command);
        for (int j = 0; j < matrix.length; j++) {
            for (int i = 1; i < matrix.length - 1 - j; i++) {
                if (matrix[i][sortIndex].compareTo(matrix[i + 1][sortIndex]) > 0) {
                    String[] changer = matrix[i];
                    matrix[i] = matrix[i + 1];
                    matrix[i + 1] = changer;
                }
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);

                if (col != matrix[row].length - 1){
                    System.out.printf(" | ");
                }
            }
            System.out.println();
        }
    }

    private static void hideOperation(String[][] matrix, String command) {
        int hiddenIndex = getHiddenIndex(matrix[0], command);

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col <matrix[row].length ; col++) {
                if(col == hiddenIndex){ continue; }

                System.out.print(matrix[row][col]);

                if (col != matrix[row].length - 1){
                    if (!(col == matrix[row].length - 2 && hiddenIndex == col+1)) {
                        System.out.printf(" | ");
                    }
                }
            }
            System.out.println();
        }


    }

    private static int getHiddenIndex(String[] matrix, String command) {
        int hiddenIndex = 0;
        for (int i = 0; i < matrix.length; i++) {
                if (matrix[i].equals(command)){
                    hiddenIndex = i;
                    break;
                }
        }
        return hiddenIndex;
    }
}
