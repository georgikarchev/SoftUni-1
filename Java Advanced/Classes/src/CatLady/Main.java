package CatLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Cat> cats = new HashMap<>();

        String line;
        while (true) {
            if ("End".equals(line = reader.readLine())) {
                break;
            }
            
            String[] tokens = line.split("\\s+");
            String catType = tokens[0];
            String catName = tokens[1];
            double additionalParameter = Double.parseDouble(tokens[2]);

            Cat cat = null;
            switch (catType) {
                case "Siamese":
                    cat = new Siamese(catType, catName, additionalParameter);
                    break;
                case "Cymric":
                    cat = new Cymric(catType, catName, additionalParameter);
                    break;
                case "StreetExtraordinaire":
                    cat = new StreetExtraordinaire(catType, catName, additionalParameter);
                    break;
            }

            cats.put(catName, cat);
        }

        System.out.println(cats.get(reader.readLine()));
    }
}
