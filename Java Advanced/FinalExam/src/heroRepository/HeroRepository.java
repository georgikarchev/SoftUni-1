package heroRepository;

import java.util.*;

public class HeroRepository {
    public Map<String, Hero> data;


    public HeroRepository() {
        this.data = new HashMap();
    }

    public void add(Hero hero){
        data.putIfAbsent(hero.getName(), hero);
    }

    public void remove(String name){
       if(data.containsKey(name)){
           data.remove(name);
       }
    }


    public Hero getHeroWithHighestStrength(){
        int maxStrength = Integer.MIN_VALUE;
        String heroName = "";
        for (Hero hero:data.values()) {
            if(hero.getItem().getStrength() > maxStrength){
                maxStrength = hero.getItem().getStrength();
                heroName= hero.getName();
            }
        }

        Hero heroToReturn = data.get(heroName);
        return heroToReturn;
    }

    public Hero getHeroWithHighestAgility(){
        int maxAgility = Integer.MIN_VALUE;
        String heroName = "";
        for (Hero hero:data.values()) {
            if(hero.getItem().getAgility() > maxAgility){
                maxAgility = hero.getItem().getAgility();
                heroName= hero.getName();
            }
        }

        Hero heroToReturn = data.get(heroName);
        return heroToReturn;
    }

    public Hero getHeroWithHighestIntelligence(){
        int maxIntel = Integer.MIN_VALUE;
        String heroName = "";
        for (Hero hero:data.values()) {
            if(hero.getItem().getIntelligence() > maxIntel){
                maxIntel = hero.getItem().getIntelligence();
                heroName= hero.getName();
            }
        }

        Hero heroToReturn = data.get(heroName);
        return heroToReturn;
    }

    public int getCount(){
        return  data.size();
    }

    @Override
    public String toString() {
        ArrayList<String> toPrint = new ArrayList<>();
        for (Hero hero: data.values()) {
            toPrint.add(hero.toString());
        }
        return String.join("", toPrint);
    }
}
