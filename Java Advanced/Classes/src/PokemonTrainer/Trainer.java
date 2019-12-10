package PokemonTrainer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.numberOfBadges = 0;
        this.pokemons = new ArrayList<>();
    }

    public int getNumberOfBadges() {
        return this.numberOfBadges;
    }

    public void increaseBadgesWithOne() {
        this.numberOfBadges += 1;
    }

    public boolean hasPokemonByGivenElement(String element) {
        return this.pokemons.stream().anyMatch(p -> p.getElement().equals(element));
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void decreasePokemonsHealth() {
        this.pokemons.forEach(Pokemon::decreaseHealth);
    }

    public void removeDeadPokemons() {
        this.pokemons.removeIf(p -> p.getHealth() <= 0);
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.numberOfBadges, this.pokemons.size());
    }
}
