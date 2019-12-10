package heroRepository;

public class Item {
    private int strength;
    private int intelligence;
    private int agility;

    public Item(int strenght, int agility, int intelligence) {
        this.strength = strenght;
        this.agility= agility;
        this.intelligence = intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getAgility() {
        return agility;
    }

    @Override
    public String toString() {
        return String.format("Item:%n  *  Strength: %d%n  *  Agility: %d%n  *  Intelligence: %d",
                this.strength, this.agility, this.intelligence);




    }
}
