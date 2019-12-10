package softUniParking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parking {
    private Map<String, Car> cars;
    private int capacity;

    public Parking(int capacity) {
        this.cars = new HashMap<>();
        this.capacity = capacity;
    }

    public String addCar(Car car){
        if (cars.containsKey(car.getRegistrationNumber())) {
            return "Car with that registration number, already exists!";
        }else if(cars.size() == capacity){
            return "Parking is full!";
        }else{
            // putIfAbset if don't works
            cars.putIfAbsent(car.getRegistrationNumber(), car);
            return "Successfully added new car " + car.getMake() + " " + car.getRegistrationNumber();
        }
    }

    public String removeCar(String regNumber){
        if (!cars.containsKey(regNumber)) {
            return "Car with that registration number, doesn't exists!";
        }

        cars.remove(regNumber);
        return "Successfully removed " + regNumber;
    }

    public Car getCar(String regNumber){
        return cars.get(regNumber);
    }

    public void removeSetOfRegistrationNumber(List<String> registrationNumbers){
        for (String regNumber: registrationNumbers) {
            this.removeCar(regNumber);
        }
    }

    public int getCount(){
        return cars.size();
    }
}
