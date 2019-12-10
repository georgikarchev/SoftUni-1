package SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countCarsToTrack = Integer.parseInt(reader.readLine());

        Map<String, Car> cars = new LinkedHashMap<>();

        while (countCarsToTrack-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");

            String model = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double fuelCostPerKilometer = Double.parseDouble(tokens[2]);

            Car car = new Car(model, fuelAmount, fuelCostPerKilometer);

            cars.putIfAbsent(model, car);
        }

        String line;
        while (true) {
            if ("End".equals(line = reader.readLine())) {
                break;
            }
            
            String[] tokens = line.split("\\s+");
            
            String model = tokens[1];
            int amountOfKm = Integer.parseInt(tokens[2]);

            Car car = cars.get(model);

            if (car.hasSufficientFuel(amountOfKm)) {
                car.reduceFuel(amountOfKm);
                car.increaseTravelledDistance(amountOfKm);
            } else {
                System.out.println("Insufficient fuel for the drive");
            }
        }

        cars.values().forEach(System.out::println);
    }
}
