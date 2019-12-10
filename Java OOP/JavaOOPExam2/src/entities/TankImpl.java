package entities;

import entities.interfaces.Tank;

public class TankImpl extends BaseMachine implements Tank {
    private boolean defenseMode;
    private final double attackPointsModifier = 40.0;
    private final double deffencePointsModifier = 30.0 ;
    public TankImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, 100 );
        this.defenseMode = true;
}

    @Override
    public boolean getDefenseMode() {
        if(this.defenseMode == true){
            this.defenseMode = false;
            return true;
        }else{
            this.defenseMode = true;
            return false;
        }
    }

    @Override
    public void toggleDefenseMode() {
        if(this.getDefenseMode()){
            this.setDefensePoints(this.getAttackPoints() - attackPointsModifier);
            this.setAttackPoints(this.getDefensePoints() + deffencePointsModifier);
        }else{
            this.setDefensePoints(this.getAttackPoints() + attackPointsModifier);
            this.setAttackPoints(this.getDefensePoints() - deffencePointsModifier);
        }
    }

    @Override
    public String toString() {
        String mode = "";
        if(this.defenseMode == true){
            mode = "OF";
        }else{
            mode = "ON";
        }
        return super.toString() + String.format("Aggressive Mode(%s)\n", mode);
    }
}
