package Telephony;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbersInput = scanner.nextLine().split("[\\s]+");
        String[] urlsInput = scanner.nextLine().split("[\\s]+");

        Smartphone iphone = new Smartphone(Arrays.asList(numbersInput),
                Arrays.asList(urlsInput));

        System.out.println(iphone.toString());
    }

}
