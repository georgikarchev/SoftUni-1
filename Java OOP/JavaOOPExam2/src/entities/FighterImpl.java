package entities;

import entities.interfaces.Fighter;

public class FighterImpl extends BaseMachine implements Fighter {
    private boolean aggressiveMode;
    private final double attackPointsModifier = 50.0;
    private final double deffencePointsModifier = 25.0;
    public FighterImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, 200 );
        this.aggressiveMode = true;

    }

    @Override
    public boolean getAggressiveMode() {
        if(this.aggressiveMode == true){
            this.aggressiveMode = false;
            return true;
        }else{
            this.aggressiveMode = true;
            return false;
        }
    }

    @Override
    public void toggleAggressiveMode() {

        if(this.getAggressiveMode()){
            this.setDefensePoints(this.getDefensePoints() + deffencePointsModifier);
            this.setAttackPoints(this.getDefensePoints() + attackPointsModifier);
        }else{
            this.setDefensePoints(this.getDefensePoints() - deffencePointsModifier);
            this.setAttackPoints(this.getDefensePoints() - attackPointsModifier);
        }
    }

    @Override
    public String toString() {
        String mode = "";
        if(this.aggressiveMode == true){
            mode = "OF";
        }else{
            mode = "ON";
        }
        return super.toString() + String.format("Aggressive Mode($s)\n", mode);
    }
}
