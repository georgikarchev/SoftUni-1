import core.ManagerControllerImpl;
import core.interfaces.ManagerController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] commandArgs;
        String command = scanner.nextLine();

        ManagerController managerController = new ManagerControllerImpl();

        myLoop:
        while(!(command.equalsIgnoreCase("Exit"))){
             commandArgs = command.split(" ");
            switch (commandArgs[0]){
                case "AddPlayer":
                    System.out.println(managerController.addPlayer(commandArgs[1], commandArgs[2]));
                    break;
                case "AddCard":
                    System.out.println(managerController.addCard(commandArgs[1], commandArgs[2]));
                    break;
                case"AddPlayerCard":
                    System.out.println(managerController.addPlayerCard(commandArgs[1], commandArgs[2]));
                    break;
                case"Fight":
                    System.out.println(managerController.fight(commandArgs[1], commandArgs[2]));
                    break;
                case"Report":
                    System.out.println(managerController.report());
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
