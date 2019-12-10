package PokemonTrainer0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Trainer> trainers = new LinkedHashMap<>();

        String line;
        while (true) {
            if ("Tournament".equals(line = reader.readLine())) {
                break;
            }

            String[] tokens = line.split("\\s+");

            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            Trainer trainer;
            if (trainers.containsKey(trainerName)) {
                trainer = trainers.get(trainerName);
            } else {
                trainer = new Trainer(trainerName);
            }

            trainer.addPokemon(pokemon);

            trainers.putIfAbsent(trainerName, trainer);
        }

        String element;
        while (true) {
            if ("End".equals(element = reader.readLine())) {
                break;
            }

            String finalElement = element;
            trainers.values().forEach(t -> {
                if (t.hasPokemonByGivenElement(finalElement)) {
                    t.increaseBadgesWithOne();
                } else {
                    t.decreasePokemonsHealth();
                }

                t.removeDeadPokemons();
            });
        }

        trainers.values().stream()
                .sorted(Comparator.comparing(Trainer::getNumberOfBadges, Comparator.reverseOrder()))
                .forEach(System.out::println);
    }
}
