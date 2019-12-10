import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MaxElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        TreeSet<Integer> container = new TreeSet<>();

        int limit = Integer.valueOf(reader.readLine());

        for (int cmdInd = 0; cmdInd < limit; cmdInd++) {
            String line = reader.readLine();
            byte cmd;
            int val;

            if (line.length() > 1) {
                val = Integer.parseInt(line.substring(2));
                stack.push(val);
                container.add(val);
            } else {
                cmd = Byte.parseByte(line);
                if (cmd == 2) {
                    container.remove(stack.pop());
                } else if (cmd == 3) {
                    System.out.println(container.last());
                }
            }
        }
    }
}