import core.Engine;
import core.SystemExam;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        SystemExam systemExam = new SystemExam();
        Engine engine = new Engine(systemExam);

        engine.run();

        System.out.println(systemExam.toString());
    }
}
