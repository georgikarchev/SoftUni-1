package SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostPerKilometer;
    private int travelledDistance;

    public Car(String model, double fuelAmount, double fuelCostPerKilometer) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKilometer = fuelCostPerKilometer;
        this.travelledDistance = 0;
    }

    private double calculateFuelByAmountOfKilometers(int amountOfKilometers) {
        return this.fuelCostPerKilometer * amountOfKilometers;
    }

    public boolean hasSufficientFuel(int amountOfKilometers) {
        return this.fuelAmount >= this.calculateFuelByAmountOfKilometers(amountOfKilometers);
    }

    public void reduceFuel(int amountOfKilometers) {
        this.fuelAmount -=  this.calculateFuelByAmountOfKilometers(amountOfKilometers);
    }

    public void increaseTravelledDistance(int amountOfKm) {
        this.travelledDistance += amountOfKm;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.travelledDistance);
    }
}
