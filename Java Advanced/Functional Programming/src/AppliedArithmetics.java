import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();
        Function<int[], int[]> add = arrNum -> Arrays.stream(arrNum).map(num -> ++num).toArray();
        Function<int[], int[]> subtract = arrNum -> Arrays.stream(arrNum).map(num -> --num).toArray();
        Function<int[], int[]> multiply = arrNum -> Arrays.stream(arrNum).map(num -> num *= 2).toArray();
        Consumer<int[]> printer = arr -> Arrays.stream(arr).forEach(e -> System.out.print(e + " "));

        while (!command.equals("end")){
            switch(command) {
                case "add":
                    numbers = add.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtract.apply(numbers);
                    break;
                    default:
                        printer.accept(numbers);
                        System.out.println();


            }
            command = scanner.nextLine();
        }
    }
}
