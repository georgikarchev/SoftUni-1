package entities;

import entities.interfaces.Machine;
import entities.interfaces.Pilot;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseMachine implements Machine {
    private String name;
    private Pilot pilot;
    private double attackPoints ;
    private double defensePoints ;
    private double healthPoints ;
    private List<String> targets;

    protected BaseMachine(String name, double attackPoints, double defensePoints, double healthPoints) {
        this.name = name;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.healthPoints = healthPoints;
        this.targets = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Pilot getPilot() {
        return this.pilot;
    }

    @Override
    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    @Override
    public double getHealthPoints() {
        return this.healthPoints;
    }

    @Override
    public void setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;
        if(this.healthPoints < 0){
            this.healthPoints = 0;
        }
    }

    @Override
    public double getAttackPoints() {
        return this.attackPoints;
    }

    @Override
    public double getDefensePoints() {
        return this.defensePoints;
    }

    @Override
    public List<String> getTargets() {
        return this.targets;
    }

    @Override
    public void attack(String target) {
        if(target.equals(" ") || target == null){
            throw new IllegalArgumentException("Attack target cannot be null or empty string.");
        }

        this.targets.add(target);
    }

    public void setAttackPoints(double attackPoints) {
        this.attackPoints = attackPoints;
    }

    public void setDefensePoints(double defensePoints) {
        this.defensePoints = defensePoints;
    }

    @Override
    public String toString() {
        return String.format("*Type: %s \n" +
                " *Health: %f\n" +
                " *Attack: %f\n" +
                " *Defense: %f\n" +
                " *Targets: %s\n",
                this.getClass().getSimpleName(), this.getHealthPoints(),
                this.getAttackPoints(), this.getDefensePoints(), String.join(" ",this.getTargets()));
    }
}
