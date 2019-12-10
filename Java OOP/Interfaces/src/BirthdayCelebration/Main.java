package BirthdayCelebration;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String basepath = System.getProperty("user.dir");
        List<String> names = new ArrayList<>();
        List<String> namesZero = new ArrayList<>();

        Citizen citizen = new Citizen("pseho", 18, "aseeds", "mainata ti");

        citizen.getBirthDate();


        String dir = basepath + "/test/";
        List<Path> collect = Files.walk(Paths.get(dir))
                .filter(f -> {
                    boolean a = f.getFileName().toString().endsWith(".java");
                    return a;
                }).collect(Collectors.toList());


        String destFolder = dir + "/Judge/";
        String path = "E:\\JAVAAA\\JudgeTEsts\\test\\";

        for (int i = 0; i < collect.size() - 1; i++) {

            String filename = collect.get(i + 1).getFileName().toString();
            if (i <= 4) {
                namesZero.add(filename);
                continue;
            }
            names.add(filename);


        }

        for (int j = 0; j < namesZero.size(); j++) {
            String currentFileName = namesZero.get(j);

            PrintWriter writer = new PrintWriter((String.format("%stest.000.0%02d.out.txt", destFolder, (j + 1))));
            writer.println("Test Passed!");
            writer.close();

            OutputStream os = new FileOutputStream(new File(String.format("%stest.000.0%02d.in.txt", destFolder, (j + 1))));
            Files.copy(Paths.get(path + currentFileName), os);
            os.close();
        }

        for (int i = 0; i < names.size(); i++) {

            PrintWriter writer = new PrintWriter((String.format("%stest.0%02d.out.txt", destFolder, (i + 1))));
            writer.println("Test Passed!");
            writer.close();

            String currentFileName = names.get(i);

            OutputStream os = new FileOutputStream(new File(String.format("%stest.0%02d.in.txt", destFolder, (i + 1))));
            Files.copy(Paths.get(path + currentFileName), os);
            os.close();


        }


    }

}
