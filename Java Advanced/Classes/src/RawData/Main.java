package RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countOfCars = Integer.parseInt(reader.readLine());

        List<Car> cars = new ArrayList<>();

        while (countOfCars-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");

            String carModel = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            String[] tiresTokens = Arrays.stream(tokens).skip(5).toArray(String[]::new);

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            Car car = new Car(carModel, engine, cargo);

            for (int i = 0; i < tiresTokens.length; i+=2) {
                double pressure = Double.parseDouble(tiresTokens[i]);
                int age = Integer.parseInt(tiresTokens[i + 1]);

                Tire tire = new Tire(pressure, age);

                car.addTire(tire);
            }

            cars.add(car);
        }

        String cargoType = reader.readLine();

        if (cargoType.equals("fragile")) {
            cars.stream()
                    .filter(car -> car.getCargo().getType().equals(cargoType) && car.getTires().stream().anyMatch(t -> t.getPressure() < 1))
                    .map(Car::getModel)
                    .forEach(System.out::println);
        } else {
            cars.stream()
                    .filter(car -> car.getCargo().getType().equals(cargoType) && car.getEngine().getPower() > 250)
                    .map(Car::getModel)
                    .forEach(System.out::println);
        }
    }
}
