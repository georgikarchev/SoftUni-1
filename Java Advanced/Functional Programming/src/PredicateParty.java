import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String[] commands = scanner.nextLine().split(" ");

        while(!commands[0].equals("Party!")){
            String command = commands[0];
            String criteria = commands[1];
            String value = commands[2];

            Predicate<String> starts = x -> x.startsWith(value);
            Predicate<String> ends = x -> x.endsWith(value);
            Predicate<String> lenght = x -> x.length() == Integer.parseInt(value);
            Predicate<String> currentPrediction = null;

            switch(criteria){
                case "StartsWith":
                    currentPrediction = starts;
                    break;
                case "EndsWith":
                    currentPrediction = ends;
                    break;
                case "Length":
                    currentPrediction = lenght;
                    break;
            }

            if (command.equals("Double")){
                guests = doubleOperation(currentPrediction, guests);
            }else{
                guests.removeIf(currentPrediction);
            }

            commands = scanner.nextLine().split(" ");
        }

        Collections.sort(guests);

        if (guests.size() > 0){
            int firstChecker = guests.size();
            int secondChecker = 1;
            for(String guest : guests) {
                if(firstChecker != secondChecker){
                    System.out.print(guest + ", ");
                    secondChecker++;
                }else{
                    System.out.print(guest + " are going to the party!");
                }
            }
        }else {
            System.out.printf("Nobody is going to the party!");
        }
    }

    private static List<String> doubleOperation(Predicate<String> currentPrediction, List<String> guests) {
        List<String> arrayList = new ArrayList<>();
        for (String person : guests) {
            if (currentPrediction.test(person)) {
                arrayList.add(person);
            }
            arrayList.add(person);
        }
        return arrayList;
    }
}