package cresla.Modules;

import cresla.interfaces.AbsorbingModule;

public abstract class AbsorberModuleBase extends BaseModules implements AbsorbingModule {
    private int heatAbsorbing;

    protected AbsorberModuleBase(int id, int heatAbsorbing) {
        super(id);
        this.heatAbsorbing = heatAbsorbing;
    }

    @Override
    public int getHeatAbsorbing() {
        return this.heatAbsorbing;
    }
}
