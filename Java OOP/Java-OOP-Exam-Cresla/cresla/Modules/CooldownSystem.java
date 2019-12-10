package cresla.Modules;

import cresla.interfaces.AbsorbingModule;

public class CooldownSystem  extends AbsorberModuleBase{
    public CooldownSystem(int id, int heatAbsorbing) {
        super(id, heatAbsorbing);
    }

    @Override
    public String toString() {
        return super.toString()
                + String.format("Heat Absorbing: %d", this.getHeatAbsorbing());
    }
}
