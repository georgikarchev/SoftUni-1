package CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countOfEngines = Integer.parseInt(reader.readLine());

        Map<String, Engine> engines = new LinkedHashMap<>();
        List<Car> cars = new ArrayList<>();

        while (countOfEngines-- > 0) {

            String[] tokens = reader.readLine().split("\\s+");

            processEngine(engines, tokens);
        }

        int countOfCars = Integer.parseInt(reader.readLine());

        while (countOfCars-- > 0) {

            String[] tokens = reader.readLine().split("\\s+");

            processCars(cars, engines, tokens);
        }

        cars.forEach(System.out::println);
    }

    private static void processCars(List<Car> cars, Map<String, Engine> engines, String[] tokens) {
        String model = tokens[0];
        String engineModel = tokens[1];

        Engine engine = engines.get(engineModel);

        Car car = null;
        switch (tokens.length) {
            case 2:
                car = new Car(model, engine);
                break;
            case 3:
                if (tokens[2].matches("\\d+")) {
                    int weight = Integer.parseInt(tokens[2]);
                    car = new Car(model, engine, weight);
                } else {
                    String color = tokens[2];
                    car = new Car(model, engine, color);
                }
                break;
            case 4:
                int weight = Integer.parseInt(tokens[2]);
                String color = tokens[3];
                car = new Car(model, engine, weight, color);
        }

        cars.add(car);
    }

    private static void processEngine(Map<String, Engine> engines, String[] tokens) {

        String model = tokens[0];
        int power = Integer.parseInt(tokens[1]);

        Engine engine = null;
        switch (tokens.length) {
            case 2:
                engine = new Engine(model, power);
                break;
            case 3:
                if (tokens[2].matches("\\d+")) {
                    int displacement = Integer.parseInt(tokens[2]);
                    engine = new Engine(model, power, displacement);
                } else {
                    String efficiency = tokens[2];
                    engine = new Engine(model, power, efficiency);
                }
                break;
            case 4:
                int displacement = Integer.parseInt(tokens[2]);
                String efficiency = tokens[3];
                engine = new Engine(model, power, displacement, efficiency);
        }

        engines.putIfAbsent(model, engine);
    }
}
