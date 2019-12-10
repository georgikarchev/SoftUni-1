package cresla;

import cresla.interfaces.Manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Manager  manager = new ManagerImpl();

        String input = "";
        //List<String> commandArgs = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        String command = bf.readLine();
        List<String> commandArgs;
        label:
        while (true) {
            commandArgs = Arrays.stream(command.split(" ")).collect(Collectors.toList());

            switch (commandArgs.get(0)) {
                case "Reactor":
                    input += manager.reactorCommand(commandArgs);
                    break;
                case "Module":
                    input += manager.moduleCommand(commandArgs);
                    break;
                case "Report":
                    input += (manager.reportCommand(commandArgs));

                    break;
                case "Exit":
                    bf.close();
                    break label;
            }
            command = bf.readLine();
        }

        if(input!= ""){
            input += manager.toString();
            System.out.print(input);
        }

    }
}
