import java.util.Scanner;

public class Sneaking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        char[][] matrixRoom = new char[rows][];
        int[] samPosition = new int[2];
        int[] nikolasPosition = new int[2];
        boolean samIsDead = false;
        boolean samKillsNikolas = false;

        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine();
            matrixRoom[i] = line.toCharArray();

            if(line.contains("N")){
                nikolasPosition[0] = i;
                nikolasPosition[1] = line.indexOf("N");
            }else if(line.contains("S")){
                samPosition[0] = i;
                samPosition[1] = line.indexOf("S");
            }
        }

        String command = scanner.nextLine();

        for (int i = 0; i < command.length(); i++) {
            EnemiesMove(matrixRoom);
            samIsDead = isSamDead(matrixRoom, samPosition);

            if(samIsDead){
                matrixRoom[samPosition[0]][samPosition[1]] = 'X';
                System.out.println("Sam died at " + samPosition[0] + ", " + samPosition[1]);
                break;
            }

            samMove(samPosition,matrixRoom, command.charAt(i));
            samKillsNikolas = doesSamKillsNikolas(samPosition[0], nikolasPosition[0]);

            if(samKillsNikolas){
                matrixRoom[nikolasPosition[0]][nikolasPosition[1]] = 'X';
                System.out.println("Nikoladze killed!");
                break;
            }
        }
        System.out.printf("");

        printMatrix(matrixRoom);

    }

    private static boolean doesSamKillsNikolas(int samRow, int nikRow) {
        if(samRow == nikRow){ return  true; }
        return false;
    }

    private static void printMatrix(char[][] matrixRoom) {
        for (int i = 0; i < matrixRoom.length; i++) {
            for (int j = 0; j < matrixRoom[i].length ; j++) {
                System.out.print(matrixRoom[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean isSamDead(char[][] matrixRoom, int[] samPosition) {
        for (int i = 0; i < matrixRoom[samPosition[0]].length ; i++) {
            if(matrixRoom[samPosition[0]][i] == 'b' ){
                if(i < samPosition[1]){
                    return  true;
                }
            }else if(matrixRoom[samPosition[0]][i] == 'd'){
                if(i > samPosition[1]){
                    return true;
                }
            }
        }

        return false;
    }

    private static void samMove(int[] samPosition, char[][] matrixRoom, char direction) {
        if(direction == 'U'){
            samPosition[0] = samPosition[0] - 1;
            matrixRoom[samPosition[0]][samPosition[1]] = 'S';
            matrixRoom[samPosition[0] + 1][samPosition[1]] = '.';
        }else if(direction == 'D'){
            samPosition[0] = samPosition[0] + 1;
            matrixRoom[samPosition[0]][samPosition[1]] = 'S';
            matrixRoom[samPosition[0] - 1][samPosition[1]] = '.';
        }else if(direction == 'L'){
            samPosition[1] = samPosition[1] - 1;
            matrixRoom[samPosition[0]][samPosition[1]] = 'S';
            matrixRoom[samPosition[0]][samPosition[1] + 1] = '.';
        }else if(direction == 'R'){
            samPosition[1] = samPosition[1] + 1;
            matrixRoom[samPosition[0]][samPosition[1]] = 'S';
            matrixRoom[samPosition[0]][samPosition[1] - 1] = '.';
        }
    }

    private static void EnemiesMove(char[][] matrixRoom) {
        for (int rows = 0; rows < matrixRoom.length ; rows++) {
            for (int cols = 0; cols < matrixRoom[rows].length; cols++) {

                if(matrixRoom[rows][cols] == 'b'){
                    if(cols == matrixRoom[rows].length - 1){
                        matrixRoom[rows][cols] = 'd';
                    }else{
                        matrixRoom[rows][cols] = '.';
                        matrixRoom[rows][cols + 1] = 'b';
                        break;
                    }
                } else if(matrixRoom[rows][cols] == 'd'){
                    if(cols == 0){
                        matrixRoom[rows][cols] = 'b';
                    }else{
                        matrixRoom[rows][cols] = '.';
                        matrixRoom[rows][cols - 1] = 'd';
                        break;
                    }
                }
            }

        }
    }
}