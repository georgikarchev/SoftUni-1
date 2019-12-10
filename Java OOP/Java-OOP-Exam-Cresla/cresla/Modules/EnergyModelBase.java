package cresla.Modules;

import cresla.interfaces.EnergyModule;

public abstract class EnergyModelBase extends BaseModules implements EnergyModule {
    private int energyOutput;
    protected EnergyModelBase(int id, int energyOutput){
        super(id);
        this.energyOutput = energyOutput;
    }

    @Override
    public int getEnergyOutput() {
        return this.energyOutput ;
    }
}
