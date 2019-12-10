package OpinionPoll;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countOfPeople = Integer.parseInt(reader.readLine());

        List<Person> people = new ArrayList<>();

        while (countOfPeople-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");

            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));

            people.add(person);
        }

        people.stream()
                .filter(p -> p.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
    }
}
