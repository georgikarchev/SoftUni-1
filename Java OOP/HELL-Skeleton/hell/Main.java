package hell;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();


        while(input != "Quit") {
            List<String> arguments = Arrays.asList(input.split(" "));

            switch (arguments.get(0)){
                case "Hero":
                    System.out.println(manager.addHero(arguments));
                    break;
                case "Item":
                    System.out.println(manager.addItem(arguments));
                    break;
            }
            input = scanner.nextLine();
        }
    }
}