import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> getMinNumber = numbersArr -> {
            int minNumber = Integer.MAX_VALUE;

            for (Integer number : numbersArr) {
                if (minNumber > number) {
                    minNumber = number;
                }
            }

            return minNumber;
        };

        System.out.println(getMinNumber.apply(numbers));

    }
}