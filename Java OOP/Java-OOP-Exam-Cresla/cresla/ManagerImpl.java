package cresla;

import cresla.Modules.CooldownSystem;
import cresla.Modules.CryogenRod;
import cresla.Modules.HeatProcessor;
import cresla.Reactors.BaseReactor;
import cresla.Reactors.CryoReactor;
import cresla.Reactors.HeatReactor;
import cresla.interfaces.*;
import cresla.interfaces.Module;

import java.util.HashMap;
import java.util.List;

public class ManagerImpl implements Manager {
    private HashMap<Integer, BaseReactor> reactors;
    public int id = 1;
    public int crioCount = 0;
    public int heatCount = 0;
    public int energyModelCount = 0;
    public int heatModelCount = 0;

    public ManagerImpl() {
        this.reactors = new HashMap<>();
    }

    @Override
    public String reactorCommand(List<String> arguments) {
        BaseReactor reactor;
        String type = arguments.get(1);
        int additionalParameter = Integer.parseInt(arguments.get(2));
        int moduleCapacity = Integer.parseInt(arguments.get(3));

        if(type.equalsIgnoreCase("Cryo")){
                reactor = new CryoReactor(id, additionalParameter, moduleCapacity);
                crioCount++;
        }else {
            reactor = new HeatReactor(id, additionalParameter, moduleCapacity);
            heatCount++;
        }

        reactors.putIfAbsent(id ,reactor);
        return String.format("Created %s Reactor - %d\n", type, id++);
    }

    @Override
    public String moduleCommand(List<String> arguments) {
        int reactorId = Integer.parseInt(arguments.get(1));
        int additionalParameter = Integer.parseInt(arguments.get(3));
        String type = arguments.get(2);
        Reactor reactorToPutModule = reactors.get(reactorId);
        Module module;

        if(type.equalsIgnoreCase( "CryogenRod")){
            module = new CryogenRod(id, additionalParameter);
            reactorToPutModule.addEnergyModule((EnergyModule) module);
            energyModelCount++;
        }else if(type.equalsIgnoreCase("CooldownSystem")){
            module = new CooldownSystem(id, additionalParameter);
            reactorToPutModule.addAbsorbingModule((AbsorbingModule) module);
            heatModelCount++;
        }else {
            module = new HeatProcessor(id, additionalParameter);
            reactorToPutModule.addAbsorbingModule((AbsorbingModule) module);
            heatModelCount++;
        }

        return String.format("Added %s - %d to Reactor - %d\n", type, id++, reactorId);
    }

    @Override
    public String reportCommand(List<String> arguments) {
        int idToPrint = Integer.parseInt(arguments.get(1));

        String string = reactors.get(idToPrint).toString();
        return string;
    }

    @Override
    public String exitCommand(List<String> arguments) {
        return null;
    }

    @Override
    public String toString() {
        long totalHeatForAll = 0;
        long totalEnergyForAll = 0;
        for (Reactor reactor: reactors.values()) {
            if(reactor.getTotalEnergyOutput() < reactor.getTotalHeatAbsorbing()) {
                totalEnergyForAll += reactor.getTotalEnergyOutput();
                totalHeatForAll += reactor.getTotalHeatAbsorbing();
            }
        }
        StringBuilder sb = new StringBuilder("Cryo Reactors: ").append(crioCount).append("\n");
        sb.append("Heat Reactors: ").append(heatCount).append("\n");
        sb.append("Energy Modules: ").append(energyModelCount).append("\n");
        sb.append("Absorbing Modules: ").append(heatModelCount).append("\n");
        sb.append("Total Energy Output: ").append(totalEnergyForAll).append("\n");
        sb.append("Total Heat Absorbing: ").append(totalHeatForAll);

        return sb.toString();
    }
}
