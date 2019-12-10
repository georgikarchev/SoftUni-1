package RawData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tires;

    public Car(String model, Engine engine, Cargo cargo) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = new ArrayList<>();
    }

    public void addTire(Tire tire) {
        if (this.tires.size() == 4) {
            return;
        }
        this.tires.add(tire);
    }

    public String getModel() {
        return this.model;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public List<Tire> getTires() {
        return Collections.unmodifiableList(this.tires);
    }
}
