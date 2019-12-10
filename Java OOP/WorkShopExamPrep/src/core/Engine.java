package core;

import hardwareComponents.HeavyHardware;
import hardwareComponents.PowerHardware;
import softwareComponents.ExpressSoftware;
import softwareComponents.LightSoftware;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine{
    private SystemExam systemExam;

    public Engine(SystemExam systemExam) {
        this.systemExam = systemExam;
    }

    public void run() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = bufferedReader.readLine();

        while(!input.equals("System Split")) {
            String command = input.substring(0, input.indexOf("("));

            String[] commandArgs = input
                    .substring(input.indexOf("(") + 1, input.indexOf(")")).split(", ");

            switch (command) {
                case "RegisterPowerHardware":
                    this.systemExam.addHardware(new PowerHardware(
                            commandArgs[0],
                            Integer.parseInt(commandArgs[1]),
                            Integer.parseInt(commandArgs[2])
                    ));
                    break;
                case "RegisterHeavyHardware":
                    this.systemExam.addHardware(new HeavyHardware(
                            commandArgs[0],
                            Integer.parseInt(commandArgs[1]),
                            Integer.parseInt(commandArgs[2])
                    ));
                    break;
                case "RegisterExpressSoftware":
                    this.systemExam.addSoftwareComponents(
                            commandArgs[0],
                            new ExpressSoftware(commandArgs[1],
                                    Integer.parseInt(commandArgs[2]),
                                    Integer.parseInt(commandArgs[3])
                            ));
                    break;
                case "RegisterLightSoftware":
                    this.systemExam.addSoftwareComponents(
                            commandArgs[0],
                            new LightSoftware(commandArgs[1],
                                    Integer.parseInt(commandArgs[2]),
                                    Integer.parseInt(commandArgs[3])
                            ));
                    break;
                case "ReleaseSoftwareComponent":
                    this.systemExam.releaseSoftwareComponents(
                            commandArgs[0], commandArgs[1]);
                    break;
                case "Analyze":
                    System.out.println(this.systemExam.analyze());
                    break;
                case "Dump":
                    this.systemExam.dumb(commandArgs[0]);
                    break;
                case "Restore":
                    this.systemExam.restore(commandArgs[0]);
                    break;
                case "Destroy(hardwareComponentName)":
                    this.systemExam.destroyHardware(commandArgs[0]);
                    break;
                case "DumpAnalyze":
                    this.systemExam.dumbAnalysis();
                    break;

            }

            input = bufferedReader.readLine();
        }

        bufferedReader.close();
    }
}
