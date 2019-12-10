import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReverseAndExucude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());
        int devidingNumber = Integer.parseInt(scanner.nextLine());

        Collections.reverse(numbers);

        numbers.removeIf(x -> x % devidingNumber == 0);

        for (Integer integer : numbers) {
            System.out.print(integer + " ");
        }

    }
}
