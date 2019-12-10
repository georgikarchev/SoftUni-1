package hell.items;

import hell.interfaces.Recipe;

import java.util.List;

public class RecipeItem extends Items implements Recipe {
    private List<CommonItem> requiredItems;

    public RecipeItem(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus, int damageBonus) {
        super(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
    }

    @Override
    public List<String> getRequiredItems() {
        return null;
    }
}
