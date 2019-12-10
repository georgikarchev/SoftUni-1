package cresla.Modules;

public class CryogenRod extends EnergyModelBase{

    public CryogenRod(int id, int energyOutput) {
        super(id, energyOutput);
    }

    @Override
    public String toString() {
        return super.toString()
                + String.format("Energy Output: %d", this.getEnergyOutput());
    }
}
