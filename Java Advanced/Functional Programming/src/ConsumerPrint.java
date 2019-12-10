import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] text = reader.readLine().split(" ");

        Consumer<String> print = word -> System.out.println(word);

        for(String word : text){
            print.accept(word);
        }

    }
}
