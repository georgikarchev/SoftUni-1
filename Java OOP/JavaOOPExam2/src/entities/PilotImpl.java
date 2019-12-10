package entities;


import entities.interfaces.Machine;
import entities.interfaces.Pilot;

import java.util.ArrayList;
import java.util.List;

public class PilotImpl implements Pilot {
    private String name;
    private List<Machine> machines;

    public PilotImpl(String name) {
        this.name = name;
        this.machines = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.getName();
    }

    @Override
    public void addMachine(Machine machine) {
        if(machine == null){
            throw new NullPointerException("Null machine cannot be added to the pilot.");
        }

        this.machines.add(machine);
    }

    @Override
    public List<Machine> getMachines() {
        return this.machines;
    }

    @Override
    public String report() {
        StringBuilder sb =
                new StringBuilder(String.format("%s – %d machines\n", this.getName(), this.getMachines().size()));

        if(this.getMachines().size() != 0){
            for (Machine machine : this.getMachines()) {
                sb.append(machine.toString());
            }
        }
        return sb.toString();
    }
}
