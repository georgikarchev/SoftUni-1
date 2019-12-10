import java.util.ArrayDeque;
        import java.util.Arrays;
        import java.util.Scanner;

public class CustomComperator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] oddNumbers = Arrays.stream(numbers).filter(x -> x % 2 != 0).boxed().sorted(Integer::compareTo)
                .mapToInt(Integer::intValue).toArray();

        int[] evenNumbers = Arrays.stream(numbers).filter(x -> x % 2 == 0).boxed().sorted(Integer::compareTo)
                .mapToInt(Integer::intValue).toArray();

        Arrays.stream(evenNumbers).forEach(x -> System.out.print(x + " "));
        Arrays.stream(oddNumbers).forEach(x -> System.out.print(x + " "));
    }
}
