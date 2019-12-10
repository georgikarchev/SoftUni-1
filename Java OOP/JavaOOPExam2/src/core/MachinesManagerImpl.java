package core;

import common.OutputMessages;
import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import core.interfaces.MachinesManager;

import entities.FighterImpl;
import entities.TankImpl;

import entities.interfaces.Fighter;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;
import entities.interfaces.Tank;

import java.util.Map;

public class MachinesManagerImpl implements MachinesManager {
    private Map<String, Pilot> pilots;
    private Map<String, Machine> machines;
    private PilotFactory pilotFactory;
    private MachineFactory machineFactory;

    public MachinesManagerImpl(PilotFactory pilotFactory,MachineFactory machineFactory,
                               Map<String, Pilot> pilots, Map<String, Machine>  machines) {
     this.pilotFactory = pilotFactory;
     this.machineFactory = machineFactory;
     this.pilots = pilots;
     this.machines= machines;
    }


    @Override
    public String hirePilot(String name) {
        if(this.pilots.containsKey(name)){
            return String.format(OutputMessages.pilotExists, name);
        }
        Pilot pilot = pilotFactory.createPilot(name);

        pilots.put(name, pilot);

        return String.format(OutputMessages.pilotHired, name);
    }

    @Override
    public String manufactureTank(String name, double attackPoints, double defensePoints) {
        if(this.machines.containsKey(name)){
            return String.format(OutputMessages.machineExists, name);
        }
        Tank tank = machineFactory.createTank(name, attackPoints, defensePoints);
        this.machines.put(name, tank);
        return String.format(OutputMessages.tankManufactured, name, attackPoints, defensePoints);
    }

    @Override
    public String manufactureFighter(String name, double attackPoints, double defensePoints) {
        if(this.machines.containsKey(name)){
            return String.format(OutputMessages.machineExists, name);
        }
        Fighter fighter = machineFactory.createFighter(name, attackPoints, defensePoints);

        this.machines.put(name, fighter);

        return String.format(OutputMessages.fighterManufactured, name, attackPoints, defensePoints);
    }

    @Override
    public String engageMachine(String selectedPilotName, String selectedMachineName) {
        if(!this.pilots.containsKey(selectedPilotName)){
            return String.format(OutputMessages.pilotNotFound, selectedPilotName);
        }else if(!this.machines.containsKey(selectedMachineName)){
            return String.format(OutputMessages.machineNotFound, selectedMachineName);
        }

        if(this.machines.get(selectedMachineName).getPilot() == null){
            return String.format(OutputMessages.machineHasPilotAlready, selectedMachineName);
        }else{
            this.machines.get(selectedMachineName).setPilot(this.pilots.get(selectedPilotName));
            this.pilots.get(selectedPilotName).addMachine(this.machines.get(selectedMachineName));
            return String.format(OutputMessages.machineEngaged, selectedPilotName,selectedMachineName);
        }


    }

    @Override
    public String attackMachines(String attackingMachineName, String defendingMachineName)  {
        if(!this.machines.containsKey(attackingMachineName)){
            return String.format(OutputMessages.machineNotFound, attackingMachineName);
        }else if(!this.machines.containsKey(defendingMachineName)){
            return String.format(OutputMessages.machineNotFound, defendingMachineName);
        }

        Machine machineAttack = this.machines.get(attackingMachineName);
        Machine machineDeffend = this.machines.get(defendingMachineName);

        if(machineAttack.getAttackPoints() > machineDeffend.getDefensePoints()){

                    machineDeffend.setHealthPoints(machineDeffend.getHealthPoints() - machineAttack.getAttackPoints());
        }

        this.machines.get(attackingMachineName).attack(defendingMachineName);

        return String.format(OutputMessages.attackSuccessful, defendingMachineName, attackingMachineName,
                machineDeffend.getHealthPoints());
    }

    @Override
    public String pilotReport(String pilotName) {
        if(!this.pilots.containsKey(pilotName)){
            return String.format(OutputMessages.pilotNotFound, pilotName);
        }
        String pilotString = this.pilots.get(pilotName).toString();
        return pilotString;
    }

    @Override
    public String toggleFighterAggressiveMode(String fighterName) {
        if(this.machines.get(fighterName).getClass().getSimpleName().equals("FighterImpl")){
            FighterImpl fighter = (FighterImpl) this.machines.get(fighterName);
            fighter.toggleAggressiveMode();
            return String.format(OutputMessages.fighterOperationSuccessful, fighterName);
        }else{
            return String.format(OutputMessages.notSupportedOperation, fighterName);
        }
    }

    @Override
    public String toggleTankDefenseMode(String tankName) {
        if(this.machines.get(tankName).getClass().getSimpleName().equals("TankImpl")){
            TankImpl tank = (TankImpl) this.machines.get(tankName);
            tank.toggleDefenseMode();
            return String.format(OutputMessages.tankOperationSuccessful, tankName);
        }else{
            return String.format(OutputMessages.notSupportedOperation, tankName);
        }
    }
}
