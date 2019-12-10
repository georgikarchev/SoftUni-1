package core.Implenetations;

import entities.PilotImpl;
import core.interfaces.PilotFactory;
import entities.interfaces.Pilot;

public class PilotFactoryImpl implements PilotFactory {
    @Override
    public Pilot createPilot(String name) {
        PilotImpl pilot = new PilotImpl(name);

        return pilot;
    }
}
