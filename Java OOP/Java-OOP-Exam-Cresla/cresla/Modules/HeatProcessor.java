package cresla.Modules;

public class HeatProcessor extends AbsorberModuleBase {
        public HeatProcessor(int id, int heatAbsorbing) {
        super(id, heatAbsorbing);
    }

    @Override
    public String toString() {
        return super.toString()
                + String.format("Heat Absorbing: %d", this.getHeatAbsorbing());
    }
}
