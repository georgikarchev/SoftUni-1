package ClassBox;

import java.security.InvalidParameterException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double lenghtInput = Double.parseDouble(scanner.nextLine());
        double widthInput = Double.parseDouble(scanner.nextLine());
        double heightInput = Double.parseDouble(scanner.nextLine());

        try{
            Box box = new Box(lenghtInput, widthInput, heightInput);

            System.out.printf("Surface Area - %.2f", box.calculateSurfaceArea());
            System.out.println();
            System.out.printf("Lateral Surface Area - %.2f", box.calculateLateralSurfaceArea());
            System.out.println();
            System.out.printf("Volume - %.2f", box.calculateVolume());
            System.out.println();
        } catch (InvalidParameterException ex){
            System.out.println(ex.getMessage());
        }



    }
}
