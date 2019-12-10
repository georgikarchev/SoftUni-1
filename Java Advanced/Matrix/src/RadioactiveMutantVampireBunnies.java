import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class RadioactiveMutantVampireBunnies {
    private static int playerRow;
    private static int playerCol;
    private static char[][] board;
    private static boolean isDead;
    private static boolean isOutside;

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int[] dimension = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimension[0];
        int cols = dimension[1];

        board = new char[rows][cols];

        getBoard(scanner);

        String directions = scanner.nextLine();

        movePlayer(directions);

        printBoard();
    }

    private static void movePlayer(String directions)
    {
        for (int step = 0; step < directions.length(); step++) {
            char currentStep = directions.charAt(step);

            switch (currentStep){
                case 'L':
                    movePlayer(0, -1);
                    break;
                case 'U':
                    movePlayer(-1, 0);
                    break;
                case 'R':
                    movePlayer(0, 1);
                    break;
                case 'D':
                    movePlayer(1, 0);
                    break;
            }

            spread();

            if (isOutside) {
                stopGame("won");
            }
            else if (isDead){
                stopGame("dead");
            }
        }
    }

    private static void spread() {
        Deque<int[]> indexes = new ArrayDeque<>();

        for (int row = 0; row < board.length; row++){
            for (int col = 0; col < board[row].length; col++){
                if (board[row][col] == 'B'){
                    indexes.offer(new int[] { row, col });
                }
            }
        }

        while (indexes.size() > 0){
            int[] currentIndex = indexes.pollFirst();

            int targetRow = currentIndex[0];
            int targetCol = currentIndex[1];

            for (int row = targetRow - 1; row <= targetRow + 1; row++){
                if (isInside(row, targetCol)){
                    if (isPlayer(row, targetCol)){
                        isDead = true;
                    }
                    board[row][targetCol] = 'B';
                }
            }

            for (int col = targetCol - 1; col <= targetCol + 1; col++){
                if (isInside(targetRow, col)){
                    if (isPlayer(targetRow, col)){
                        isDead = true;
                    }
                    board[targetRow][col] = 'B';
                }
            }
        }
    }



    private static void movePlayer(int row, int col)
    {
        int targetRow = playerRow + row;
        int targetCol = playerCol + col;

        if (!isInside(targetRow, targetCol)){
            board[playerRow][playerCol] = '.';
            isOutside = true;
        }
        else if(IsBunny(targetRow, targetCol)){
            board[playerRow][playerCol] = '.';
            playerRow += row;
            playerCol += col;
            isDead = true;
        }
        else{
            board[playerRow][playerCol] = '.';
            playerRow += row;
            playerCol += col;
            board[playerRow][playerCol] = 'P';
        }
    }

    private static boolean isPlayer(int row, int col) {
        return board[row][col] == 'P';
    }

    private static boolean IsBunny(int row, int col){
        return board[row][col] == 'B';
    }

    private static void stopGame(String condition) {
        printBoard();
        System.out.println(String.format("%s: %d %d", condition, playerRow, playerCol));
        System.exit(0);
    }

    private static boolean isInside(int targetRow, int targetCol){
        return targetRow >= 0 && targetRow < board.length && targetCol >= 0 && targetCol < board[targetRow].length;
    }

    private static void printBoard(){
        for(char[] row : board) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static void getBoard(Scanner scanner) {
        for (int row = 0; row < board.length; row++) {
            String input = scanner.nextLine();
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = input.charAt(col);

                if (input.charAt(col) == 'P') {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }
    }
}