package hardwareComponents;

public class HeavyHardware extends Hardware{
    private static final String TYPE = "Heavy";

    public HeavyHardware(String name, int MAX_CAPACITY, int maxMemory) {
        super(name, HeavyHardware.TYPE, MAX_CAPACITY, maxMemory);
    }

    @Override
    protected void setMaxMemory(int maxMemory) {
        super.setMaxMemory(maxMemory - (maxMemory /4));
    }

    @Override
    protected void setMaxCapacity(int maxCapacity) {
        super.setMaxCapacity(maxCapacity * 2);
    }
}
