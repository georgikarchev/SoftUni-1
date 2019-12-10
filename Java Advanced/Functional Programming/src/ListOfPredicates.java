import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int[] divisibleNumber = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        Predicate<Integer> isItDivisible =  x -> {
            for(Integer checker : divisibleNumber){
                if(x % checker != 0){
                    return false;
                }
            }
            return true;
        };

        for(int counter = 1; counter <= number; counter++ ){
            if(isItDivisible.test(counter)){
                System.out.print(counter + " ");
            }
        }

    }
}
