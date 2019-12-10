package core;

import Repository.Repository;
import hardwareComponents.Hardware;
import softwareComponents.Software;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SystemExam {
    private Map<String, Hardware> hardwareComponents;
    private Repository repository = new Repository(new HashMap<>());

    public SystemExam() {
        this.hardwareComponents = new LinkedHashMap<>();
    }

    public void addHardware(Hardware hardware) {
        this.hardwareComponents.putIfAbsent(hardware.getName(), hardware);
    }

    public void addSoftwareComponents(String hardwareName, Software software) {
        if (this.hardwareComponents.containsKey(hardwareName)) {
            this.hardwareComponents.get(hardwareName).addSoftware(software);
        }
    }

    public void releaseSoftwareComponents(String hardwareName, String softwareName) {
        if (this.hardwareComponents.containsKey(hardwareName)) {
            this.hardwareComponents.get(hardwareName).releaseSoftware(softwareName);
        }
    }

    public void releaseHardwareComponents(String hardwareName) {
        this.hardwareComponents.remove(hardwareName);

    }

    public void destroyHardware(String hardwareName) {
        if (this.repository.getDumbRepository().containsKey(hardwareName)) {
            this.repository.getDumbRepository().remove(hardwareName);
        }
    }

    public void restore(String hardwareName) {
        if (this.repository.getDumbRepository().containsKey(hardwareName)) {
            Hardware hardware = this.repository.getDumbRepository().get(hardwareName);
            this.repository.getDumbRepository().remove(hardwareName);
            addHardware(hardware);
        }
    }

    public void dumb(String hardwareName) {
        if (this.hardwareComponents.containsKey(hardwareName)) {
            Hardware hardware = this.hardwareComponents.get(hardwareName);
            releaseHardwareComponents(hardwareName);
            this.repository.fillDumbRepository(hardwareName, hardware);


        }
    }

    public void dumbAnalysis() {
        ArrayList<Hardware> hardwares = (ArrayList<Hardware>) this.repository.getDumbRepository().values();




//        “Dump Analysis
//        Power Hardware Components: {countOfPowerHardwareComponents}
//        Heavy Hardware Components: {countOfHeavyHardwareComponents}
//        Express Software Components: {countOfExpressSoftwareComponents}
//        Light Software Components: {countOfLightSoftwareComponents}
//        Total Dumped Memory: {totalDumpedMemory}
//        Total Dumped Capacity: {totalDumpedCapacity}”

    }


    public String analyze() {
        int softwareComponents = 0;
        int memoryInUse = 0;
        int memoryTotal = 0;
        int capacityInUse = 0;
        int capacityTotal = 0;

        for (String name : hardwareComponents.keySet()) {
            softwareComponents += this.hardwareComponents.get(name)
                    .getSoftwareComponentsCount();
            memoryInUse += this.hardwareComponents.get(name).getUsedMemory();
            memoryTotal += this.hardwareComponents.get(name).getMaxMemory();
            capacityInUse += this.hardwareComponents.get(name).getUsedCapacity();
            capacityTotal += this.hardwareComponents.get(name).getMaxCapacity();
        }

        StringBuilder sb = new StringBuilder("System Analysis");
        sb.append(System.lineSeparator())
                .append("Hardware Components: ")
                .append(this.hardwareComponents.size())
                .append(System.lineSeparator())
                .append("Software Components: ")
                .append(softwareComponents)
                .append(System.lineSeparator())
                .append("Total Operational Memory: ")
                .append(memoryInUse)
                .append(" / ")
                .append(memoryTotal)
                .append(System.lineSeparator())
                .append("Total Capacity Taken: ")
                .append(capacityInUse)
                .append(" / ")
                .append(capacityTotal);


        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        this.hardwareComponents.entrySet()
                .stream()
                .filter(e -> e.getValue().getType().equals("Power"))
                .forEach(e ->
                        sb.append("Hardware Component - ")
                                .append(e.getKey())
                                .append(System.lineSeparator())
                                .append(e.getValue().toString())
                                .append(System.lineSeparator())
                );

        this.hardwareComponents.entrySet()
                .stream()
                .filter(e -> e.getValue().getType().equals("Heavy"))
                .forEach(e ->
                        sb.append("Hardware Component - ")
                                .append(e.getKey())
                                .append(System.lineSeparator())
                                .append(e.getValue().toString())
                );


        return sb.toString();
    }
}


