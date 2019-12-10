import core.Implenetations.MachineFactoryImpl;
import core.Implenetations.PilotFactoryImpl;
import core.MachinesManagerImpl;

import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import core.interfaces.MachinesManager;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        PilotFactory pilotFactory = new PilotFactoryImpl();
        MachineFactory machineFactory = new MachineFactoryImpl();
        Map<String, Pilot> pilots = new LinkedHashMap<>();
        Map<String, Machine> machines = new LinkedHashMap<>();

        MachinesManager machinesManager = new MachinesManagerImpl(pilotFactory, machineFactory, pilots, machines);
    }
}
