package core.Implenetations;

import entities.FighterImpl;
import entities.TankImpl;
import core.interfaces.MachineFactory;
import entities.interfaces.Fighter;
import entities.interfaces.Tank;

public class MachineFactoryImpl implements MachineFactory {

    @Override
    public Tank createTank(String name, double attackPoints, double defensePoints) {
        Tank tank = new TankImpl(name, attackPoints, defensePoints);

        return tank;
    }

    @Override
    public Fighter createFighter(String name, double attackPoints, double defensePoints) {
        FighterImpl fighter = new FighterImpl(name, attackPoints, defensePoints);

        return fighter;
    }




}
