package hardwareComponents;

import softwareComponents.Software;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Hardware {
    private String name;
    private int maxCapacity;
    private int maxMemory;
    private String type;
    private Map<String, Software> softwareComponents;
    private int usedCapacity;
    private int usedMemory;

    public Hardware(String name, String type, int maxCapacity, int maxMemory) {
        this.name = name;
        this.type = type;
        this.setMaxCapacity(maxCapacity);
        this.setMaxMemory(maxMemory);
        this.softwareComponents = new LinkedHashMap<>();
        this.usedCapacity = 0;
        this.usedMemory = 0;
    }

    protected  void setMaxMemory(int maxMemory){
     this.maxMemory = maxMemory;
    }

    protected void setMaxCapacity(int maxCapacity){
     this.maxCapacity = maxCapacity;

    }

    public String getName() {
        return name;
    }

    private boolean remainingCapacity(int capacity){
        return  (this.maxCapacity - (this.usedCapacity + capacity)) >= 0;
    }

    private boolean remainingMemory(int memory){
        return  (this.maxMemory - (this.usedMemory + memory)) >= 0;
    }

    public void addSoftware(Software software){
        if (this.remainingCapacity(software.getCapacityConsumption())
                && this.remainingMemory(software.getMemoryConsumption())) {

            this.softwareComponents.putIfAbsent(software.getName(), software);

            this.usedMemory += software.getMemoryConsumption();
            this.usedCapacity += software.getCapacityConsumption();
        }
    }

    public  void releaseSoftware(String softwareName){
        if (this.softwareComponents.containsKey(softwareName)) {
            Software software = this.softwareComponents.get(softwareName);
            this.softwareComponents.remove(softwareName);
            usedCapacity -= software.getCapacityConsumption();
            usedMemory -= software.getMemoryConsumption();
        }
    }

    public int getSoftwareComponentsCount(){
        return  this.softwareComponents.size();
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getMaxMemory() {
        return maxMemory;
    }

    public int getUsedCapacity() {
        return usedCapacity;
    }

    public int getUsedMemory() {
        return usedMemory;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        int expressCount = (int) this.softwareComponents.keySet()
                .stream()
                .filter(k -> this.softwareComponents.get(k).getType()
                        .equals("Express")).count();

        int lightCount = this.softwareComponents.size() - expressCount;


        sb.append("Express Software Components - ")
                .append(expressCount)
                .append(System.lineSeparator())
                .append("Light Software Components - ")
                .append(lightCount)
                .append(System.lineSeparator())
                .append("Memory Usage: ")
                .append(this.usedMemory)
                .append(" / ")
                .append(this.maxMemory)
                .append(System.lineSeparator())
                .append("Capacity Usage: ")
                .append(this.usedCapacity)
                .append(" / ")
                .append(this.maxCapacity)
                .append(System.lineSeparator())
                .append("Type: ")
                .append(this.getType())
                .append(System.lineSeparator())
                .append("Software Components: ");

        String[] values = this.softwareComponents.values()
                .stream()
                .map(Software::getName)
                .toArray(String[]::new);

        if (values.length == 0){
            sb.append("None");
        }else{
            sb.append(String.join(", ", values));
        }


        return sb.toString();
    }
}
