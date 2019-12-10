import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowsAndCols = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(", ");
        char[][] matrixGameRoom = new char[rowsAndCols][rowsAndCols];
        int[] snakePosition = new int[2];
        int lenghtOfTheSnake = 1;
        boolean snakeIsDead = false;
        int foodCounter = 0;

        for (int row = 0; row < matrixGameRoom.length; row++) {
            String line = scanner.nextLine();
            line = line.replaceAll("\\s", "");
            matrixGameRoom[row] = line.toCharArray();
            if (line.contains("s")) {
                snakePosition[0] = row;
                snakePosition[1] = line.indexOf("s");
            }
        }

        for (int i = 0; i < matrixGameRoom.length; i++) {
            for (int j = 0; j < matrixGameRoom[i].length; j++) {
                if (matrixGameRoom[i][j] == 'f') {
                    foodCounter++;
                }
            }
        }

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];

            if (command.equals("up")) {
                if (snakePosition[0] == 0) {
                    matrixGameRoom[snakePosition[0]][snakePosition[1]] = '*';
                    snakePosition[0] = matrixGameRoom.length - 1;
                    if(!isSnakeDead(matrixGameRoom, snakePosition)){
                        if (isThereFood(matrixGameRoom, snakePosition)) {
                            lenghtOfTheSnake = lenghtOfTheSnake +1;
                        }
                        matrixGameRoom[snakePosition[0]][snakePosition[1]] = 's';
                    }else{
                        snakeIsDead = true;
                    }

                }else {
                    matrixGameRoom[snakePosition[0]][snakePosition[1]] = '*';
                    snakePosition[0] = snakePosition[0] - 1;
                    if(!isSnakeDead(matrixGameRoom, snakePosition)){
                        if (isThereFood(matrixGameRoom, snakePosition)) {
                            lenghtOfTheSnake = lenghtOfTheSnake +1;
                        }
                        matrixGameRoom[snakePosition[0]][snakePosition[1]] = 's';
                    }else{
                        snakeIsDead = true;
                    }

                }
            }else if(command.equals("down")){
                if(snakePosition[0] == matrixGameRoom.length - 1){
                    matrixGameRoom[snakePosition[0]][snakePosition[1]] = '*';
                    snakePosition[0] = 0;

                    if(!isSnakeDead(matrixGameRoom, snakePosition)){
                        if (isThereFood(matrixGameRoom, snakePosition)) {
                            lenghtOfTheSnake = lenghtOfTheSnake +1;
                        }
                        matrixGameRoom[snakePosition[0]][snakePosition[1]] = 's';
                    }else{
                        snakeIsDead = true;
                    }
                }else{
                    matrixGameRoom[snakePosition[0]][snakePosition[1]] = '*';
                    snakePosition[0] = snakePosition[0] + 1;

                    if(!isSnakeDead(matrixGameRoom, snakePosition)){
                        if (isThereFood(matrixGameRoom, snakePosition)) {
                            lenghtOfTheSnake = lenghtOfTheSnake +1;
                        }
                        matrixGameRoom[snakePosition[0]][snakePosition[1]] = 's';
                    }else{
                        snakeIsDead = true;
                    }
                }
            }else if(command.equals("right")){
                if(snakePosition[1] == matrixGameRoom.length - 1){
                    matrixGameRoom[snakePosition[0]][snakePosition[1]] = '*';
                    snakePosition[1] = 0;

                    if(!isSnakeDead(matrixGameRoom, snakePosition)){
                        if (isThereFood(matrixGameRoom, snakePosition)) {
                            lenghtOfTheSnake = lenghtOfTheSnake +1;
                        }
                        matrixGameRoom[snakePosition[0]][snakePosition[1]] = 's';
                    }else{
                        snakeIsDead = true;
                    }
                }else{
                    matrixGameRoom[snakePosition[0]][snakePosition[1]] = '*';
                    snakePosition[1] = snakePosition[1] + 1;

                    if(!isSnakeDead(matrixGameRoom, snakePosition)){
                        if (isThereFood(matrixGameRoom, snakePosition)) {
                            lenghtOfTheSnake = lenghtOfTheSnake +1;
                        }
                        matrixGameRoom[snakePosition[0]][snakePosition[1]] = 's';
                    }else{
                        snakeIsDead = true;
                    }
                }
            }else if(command.equals("left")){
                if (snakePosition[1] == 0) {
                    matrixGameRoom[snakePosition[0]][snakePosition[1]] = '*';
                    snakePosition[1] = matrixGameRoom.length - 1;

                    if(!isSnakeDead(matrixGameRoom, snakePosition)){
                        if (isThereFood(matrixGameRoom, snakePosition)) {
                            lenghtOfTheSnake = lenghtOfTheSnake +1;
                        }
                        matrixGameRoom[snakePosition[0]][snakePosition[1]] = 's';
                    }else{
                        snakeIsDead = true;
                    }

                }else {
                    matrixGameRoom[snakePosition[0]][snakePosition[1]] = '*';
                    snakePosition[1] = snakePosition[1] - 1;

                    if(!isSnakeDead(matrixGameRoom, snakePosition)){
                        if (isThereFood(matrixGameRoom, snakePosition)) {
                            lenghtOfTheSnake = lenghtOfTheSnake +1;
                        }
                        matrixGameRoom[snakePosition[0]][snakePosition[1]] = 's';
                    }else{
                        snakeIsDead = true;
                    }

                }
            }
            if (snakeIsDead == true) {
                break;
            }

//            for (int k = 0; k < matrixGameRoom.length; k++) {
//                for (int s = 0; s < matrixGameRoom[k].length; s++) {
//                    System.out.print(matrixGameRoom[k][s]);
//                }
//                System.out.println();
//            }
//            System.out.println();


        }

        if(!snakeIsDead){
            if(foodCounter + 1 == lenghtOfTheSnake){
                System.out.println("You win! Final snake length is " + lenghtOfTheSnake);

            }else {
                System.out.println("You lose! There is still " + (foodCounter - lenghtOfTheSnake + 1)+ " food to be eaten.");
            }
        }else{
            System.out.println("You lose! Killed by an enemy!");
        }





    }

    private static void MoveTheSnake(char[][] matrixGameRoom, String command, int[] snakePosition,
                                     boolean isDead, int lenghtOfTheSnake) {

    }

    private static boolean isThereFood(char[][] matrixGameRoom, int[] snakePosition) {
        if(matrixGameRoom[snakePosition[0]][snakePosition[1]] == 'f'){
            return true;
        }
        return  false;
    }


    private static boolean isSnakeDead(char[][] matrixGameRoom, int[] snakePosition) {
        if(matrixGameRoom[snakePosition[0]][snakePosition[1]] == 'e'){
           // System.out.println("You lose! Killed by an enemy!");
            return true;
        }
        return  false;
    }
}
