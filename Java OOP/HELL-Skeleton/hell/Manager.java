package hell;

import hell.heroes.Assassin;
import hell.heroes.Barbarian;
import hell.heroes.Wizard;
import hell.interfaces.Hero;
import hell.items.CommonItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Manager implements hell.interfaces.Manager {
    private  Map<String, Hero> localHeroes;

    public Manager() {
        this.localHeroes = new HashMap<>();
    }

    @Override
    public String addHero(List<String> arguments) {
        Hero hero = null;
        String result = "";

        switch (arguments.get(2)){
            case "Barbarian":
                hero = new Barbarian(arguments.get(1));
                break;
            case "Assassin":
                hero = new Assassin(arguments.get(1));
                break;
            case "Wizard":
                hero = new Wizard(arguments.get(1));
                break;
        }
        result = String.format("Created %s - %s", arguments.get(2), arguments.get(1));
        localHeroes.put(hero.getName(), hero);
        return result;
    }

    @Override
    public String addItem(List<String> arguments) {
        String result = "";
        String itemName= arguments.get(1);
        String heroName = arguments.get(2);
        int strengthBonus= Integer.parseInt(arguments.get(3));
        int agilityBonus = Integer.parseInt(arguments.get(4));
        int intelligenceBonus = Integer.parseInt(arguments.get(5));
        int hitPointsBonus = Integer.parseInt(arguments.get(6));
        int damageBonus = Integer.parseInt(arguments.get(7));

        CommonItem item = new CommonItem(itemName, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);

        localHeroes.get(heroName).addItem(item);
        result = String.format("Added item - %s to Hero - %s", itemName,heroName );
        return result;
    }

    @Override
    public String addRecipe(List<String> arguments) {
        return null;
    }

    @Override
    public String inspect(List<String> arguments) {
        return null;
    }

    @Override
    public String quit() {
        return null;
    }
}
