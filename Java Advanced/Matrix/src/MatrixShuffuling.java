import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffuling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        String[][] myMatrix = new String[rows][cols];
        fillMatrix(myMatrix, scanner);

        String[] commands = scanner.nextLine().split(" ");

        while(!commands[0].equals("END")){
            if(validation(commands, myMatrix)){
                swapMatrix(myMatrix, commands);
                printMatrix(myMatrix);
            }else {
                System.out.println("Invalid input!");
            }
            commands = scanner.nextLine().split(" ");
        }



    }

    private static void printMatrix(String[][] myMatrix) {
        for (int row = 0; row < myMatrix.length; row++) {
            for (int col = 0; col < myMatrix[row].length; col++) {
                System.out.print(myMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void swapMatrix(String[][] myMatrix, String[] commands) {
        int s1 = Integer.parseInt(commands[1]);
        int s2= Integer.parseInt(commands[2]);
        int s3 = Integer.parseInt(commands[3]);
        int s4 = Integer.parseInt(commands[4]);
        String elementToSwap = myMatrix[s1][s2];

        myMatrix[s1][s2] = myMatrix[s3][s4];
        myMatrix[s3][s4] = elementToSwap;

    }



    private static boolean validation(String[] commands, String[][] myMatrix) {
        if (commands.length == 5){
            String command = commands[0];
            int firstRow = Integer.parseInt(commands[1]);
            int firstCol = Integer.parseInt(commands[2]);
            int secondRow = Integer.parseInt(commands[3]);
            int secondCol = Integer.parseInt(commands[4]);

            if (firstRow < myMatrix.length && firstCol < myMatrix[firstRow].length
                    && secondRow < myMatrix.length && secondCol < myMatrix[secondRow].length && command.equals("swap")){
                return true;
            }else{
                return false;
            }
        }else {
            return false;
        }
    }


    private static void fillMatrix(String[][] myMatrix, Scanner scanner) {
        for (int row = 0; row < myMatrix.length; row++) {
            myMatrix[row] = scanner.nextLine().split(" ");
        }
    }
}
