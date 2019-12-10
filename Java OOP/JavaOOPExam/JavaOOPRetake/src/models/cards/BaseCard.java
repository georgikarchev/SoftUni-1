package models.cards;

import models.cards.interfaces.Card;

public abstract class BaseCard implements Card {
    private String name;
    private int damagePoints;
    private int healthPoints;

    protected BaseCard(String name, int damagePoints, int healthPoints) {
        this.setName(name);
        this.setDamagePoints(damagePoints);
        this.setHealthPoints(healthPoints);
    }

    public void setName(String name) {
        if(name == null || name.equals("")){
            throw new IllegalArgumentException("Card's name cannot be null or an empty string.");
        }

        this.name = name;
    }

    public void setHealthPoints(int healthPoints) {
        if(healthPoints < 0 ){
            this.healthPoints = 0;
            throw new IllegalArgumentException("Card's HP cannot be less than zero.");
        }

        this.healthPoints = healthPoints;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getDamagePoints() {
        return this.damagePoints;
    }

    @Override
    public void setDamagePoints(int damagePoints) {
        if(damagePoints < 0 ){
            this.damagePoints = 0;
            throw new IllegalArgumentException("Card's damage points cannot be less than zero.");
        }

        this.damagePoints = damagePoints;
    }

    @Override
    public int getHealthPoints() {
        return this.healthPoints;
    }

    @Override
    public String toString() {
        return String.format("Card: %s - Damage: %d", this.getName(), this.getDamagePoints());
    }
}
