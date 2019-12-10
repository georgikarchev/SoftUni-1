package cresla.Reactors;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.*;
import cresla.interfaces.Module;

import java.util.HashMap;

public abstract class BaseReactor implements Reactor {
    private int id;
    private Container container;

    protected BaseReactor(int id, int moduleCapacity) {
        this.id = id;
        this.container= new ModuleContainer(moduleCapacity);
    }

    public Container getContainer() {
        return container;
    }

    @Override
    public long getTotalEnergyOutput() {
        return this.container.getTotalEnergyOutput();
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return this.container.getTotalHeatAbsorbing();

    }

    @Override
    public int getModuleCount() {
        return this.container.getModuleByInputCount();
    }

    @Override
    public void addEnergyModule(EnergyModule energyModule) {
        this.container.addEnergyModule(energyModule);
    }

    @Override
    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
        this.container.addAbsorbingModule(absorbingModule);
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder =
                new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName()).append(" - ").append(this.getId()).append("\n");
        stringBuilder.append("Energy Output: ")
                .append(this.getTotalEnergyOutput()).append("\n");
        stringBuilder.append("Heat Absorbing: ")
                .append(this.getTotalHeatAbsorbing()).append("\n");
        stringBuilder.append("Modules: ").append(this.getModuleCount()).append("\n");


      return stringBuilder.toString();
    }
}
