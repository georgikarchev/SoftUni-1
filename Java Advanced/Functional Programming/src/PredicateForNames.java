import java.util.Arrays;
        import java.util.List;
        import java.util.Scanner;
        import java.util.stream.Collectors;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nameLenght = Integer.parseInt(scanner.nextLine());
        List<String> names = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        names.stream().filter( name -> name.length() <= nameLenght).forEach(System.out::println);
    }
}
