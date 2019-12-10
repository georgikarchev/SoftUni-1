import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int playerRow = 7;
        int playerCol = 7;
        int plagueCloud = 3500;
        int eruption = 6000;
        int playerHealth = 18500;
        double heiganHealth = 3000000;
        String lastSpell = "";
        boolean isPlagueCloud = false;

        double damage = Double.parseDouble(scanner.nextLine());

        while (heiganHealth > 0 && playerHealth > 0) {

                heiganHealth -= damage;

            if (isPlagueCloud){
                playerHealth -= plagueCloud;
                isPlagueCloud = false;
            }
            if(heiganHealth <=0 || playerHealth <= 0){
                break;
            }


            String[] command = scanner.nextLine().split("\\s+");

            String magic = command[0];
            int targetRow = Integer.parseInt(command[1]);
            int targetCol = Integer.parseInt(command[2]);

            if (isInImpactArea(playerRow, playerCol, targetRow, targetCol)){
                continue;
            }

            boolean canMoveUp = isInImpactArea(playerRow - 1, playerCol, targetRow, targetCol) && isInside(playerRow - 1);
            boolean canMoveDown = isInImpactArea(playerRow + 1, playerCol, targetRow, targetCol) && isInside(playerRow + 1);
            boolean canMoveRight = isInImpactArea(playerRow, playerCol + 1, targetRow, targetCol) && isInside(playerCol + 1);
            boolean canMoveLeft = isInImpactArea(playerRow, playerCol - 1, targetRow, targetCol) && isInside(playerCol - 1);

            if (canMoveUp) {
                playerRow--;
                continue;
            }

            if (canMoveRight){
                playerCol++;
                continue;
            }

            if (canMoveDown){
                playerRow++;
                continue;
            }

            if (canMoveLeft){
                playerCol--;
                continue;
            }

            if (magic.equals("Eruption")){
                playerHealth -= eruption;
                lastSpell = "Eruption";
            }
            else if (magic.equals("Cloud")) {
                playerHealth -= plagueCloud;
                isPlagueCloud = true;
                lastSpell = "Cloud";
            }
        }

        String heiganCondition = "";
        String playerCondition = "";

        if (heiganHealth > 0){
            heiganCondition = String.format("Heigan: %.2f", heiganHealth);
        }
        else{
            heiganCondition = "Heigan: Defeated!";
        }

        if (playerHealth > 0){
            playerCondition = String.format("Player: %d", playerHealth);
        }
        else if (lastSpell.equals("Eruption")) {
            playerCondition =  "Player: Killed by Eruption";
        }
        else{
            playerCondition = "Player: Killed by Plague Cloud";
        }

        System.out.println(heiganCondition);
        System.out.println(playerCondition);
        System.out.println(String.format("Final position: %d, %d", playerRow, playerCol));
    }

    private static boolean isInside(int rcIndex) {
        return rcIndex >= 0 && rcIndex < 15;
    }

    private static boolean isInImpactArea(int currentPlayerRow, int currentPlayerCol, int targetRow, int targetCol) {
        return currentPlayerRow < targetRow - 1 || currentPlayerRow > targetRow + 1 ||
                currentPlayerCol < targetCol - 1 || currentPlayerCol > targetCol + 1;
    }
}