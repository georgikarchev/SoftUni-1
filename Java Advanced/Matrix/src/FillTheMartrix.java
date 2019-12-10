import java.util.Scanner;

public class FillTheMartrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", +");
        int size = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] myMatrix = new int[size][size];

        if (pattern.equals("A")) {
            fillMatrixWithFirstPattern(myMatrix);
        }else if (pattern.equals("B")){
            fillMatrixWithSecondPattern(myMatrix);
        }

        for (int row = 0; row < myMatrix.length; row++) {
            for (int col = 0; col < myMatrix.length; col++) {
                System.out.print(myMatrix[row][col] + " ");
            }
            System.out.println();
        }


    }

    private static void fillMatrixWithSecondPattern(int[][] myMatrix) {
        int value = 1;

        for (int col= 0; col < myMatrix.length; col++){
            if(col % 2 == 0){
                for(int row = 0; row < myMatrix.length; row++){
                    myMatrix[row][col] = value++;
                }
            }else{
                for(int row = myMatrix.length - 1; row >= 0; row--){
                    myMatrix[row][col] = value++;
                }
            }
        }
    }

    private static void fillMatrixWithFirstPattern(int[][] myMatrix) {
        int value = 1;
        for(int row = 0; row < myMatrix.length; row++){
            for (int col= 0; col < myMatrix.length; col++){
                myMatrix[col][row] = value++;
            }
        }
    }


}
