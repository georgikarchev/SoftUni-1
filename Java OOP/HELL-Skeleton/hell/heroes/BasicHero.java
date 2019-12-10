package hell.heroes;

import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.Hero;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.util.Collection;

public abstract class BasicHero implements Hero {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int hitPoints;
    private int damage;
    private Inventory inventory;

     BasicHero(String name, int strength, int agility, int intelligence, int hitPoints, int damage) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.inventory = new HeroInventory();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getStrength() {
        return this.strength + inventory.getTotalStrengthBonus();
    }

    @Override
    public long getAgility() {
        return this.agility + inventory.getTotalAgilityBonus();
    }

    @Override
    public long getIntelligence() {
        return this.intelligence + inventory.getTotalIntelligenceBonus();
    }

    @Override
    public long getHitPoints() {
        return this.hitPoints + inventory.getTotalHitPointsBonus();
    }

    @Override
    public long getDamage() {
        return this.damage + inventory.getTotalDamageBonus();
    }

    @Override
    public Collection<Item> getItems() {
        return null;
    }

    @Override
    public void addItem(Item item) {
         inventory.addCommonItem(item);
    }

    @Override
    public void addRecipe(Recipe recipe) {
         inventory.addRecipeItem(recipe);
    }
}
