package Google;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, Person> personData = new LinkedHashMap<>();

        while (true) {
            String input = reader.readLine();

            if ("End".equals(input)) {
                break;
            }

            String[] personTokens = input.split(" ");
            String name = personTokens[0];

            if (!personData.containsKey(name)) {
                personData.put(name, new Person());
            }

            switch (personTokens[1]) {
                case "children":
                    //“<Name> children <childName> <childBirthday>”
                    String childName = personTokens[2];
                    String childBirthday = personTokens[3];

                    Children children = new Children(childName, childBirthday);
                    personData.get(name).getChildrens().add(children);
                    break;
                case "company":
                    //“<Name> company <companyName> <department> <salary>”
                    String companyName = personTokens[2];
                    String department = personTokens[3];
                    Double salary = Double.parseDouble(personTokens[4]);

                    Company company = new Company(companyName, department, salary);
                    personData.get(name).setCompany(company);
                    break;
                case "pokemon":
                    //“<Name> pokemon <pokemonName> <pokemonType>”
                    String pokemonName = personTokens[2];
                    String pokemonType = personTokens[3];

                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    personData.get(name).getPokemons().add(pokemon);
                    break;
                case "parents":
                    //“<Name> parents <parentName> <parentBirthday>”
                    String parentName = personTokens[2];
                    String parentBirthday = personTokens[3];

                    Parents parent = new Parents(parentName, parentBirthday);
                    personData.get(name).getParents().add(parent);
                    break;
                case "car":
                    //“<Name> car <carModel> <carSpeed>”
                    String carModel = personTokens[2];
                    int carSpeed = Integer.parseInt(personTokens[3]);

                    Car car = new Car(carModel, carSpeed);
                    personData.get(name).setCar(car);
                    break;
            }
        }

        String wantedName = reader.readLine();
        System.out.println(wantedName);
        System.out.println("Company:");
        if (personData.get(wantedName).getCompany() != null) {
            System.out.printf("%s %s %.2f%n", personData.get(wantedName).getCompany().getCompanyName(),
                    personData.get(wantedName).getCompany().getDepartment(),
                    personData.get(wantedName).getCompany().getSalary());
        }
        System.out.println("Car:");
        if (personData.get(wantedName).getCar() != null) {
            System.out.printf("%s %d%n", personData.get(wantedName).getCar().getCarModel(), personData.get(wantedName).getCar().getCarSpeed());
        }
        System.out.println("Pokemon:");
        for (Pokemon pokemon : personData.get(wantedName).getPokemons()) {
            System.out.printf("%s %s%n", pokemon.getPokemonName(), pokemon.getPokemonType());
        }
        System.out.println("Parents:");
        for (Parents parent : personData.get(wantedName).getParents()) {
            System.out.printf("%s %s%n", parent.getParentName(), parent.getParentBirthday());
        }
        System.out.println("Children:");
        for (Children children : personData.get(wantedName).getChildrens()) {
            System.out.printf("%s %s%n", children.getChildName(), children.getChildBirthday());
        }
    }
}
