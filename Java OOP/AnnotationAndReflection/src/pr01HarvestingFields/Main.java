package pr01HarvestingFields;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    String input = scanner.nextLine();

		Field[] fields = RichSoilLand.class.getDeclaredFields();

		while(!input.equals("HARVEST")){
		    String finalInput = input;

		    if(input.equals("all")){
		        printFields(fields);
            }else{
                Field[] fieldsToPrint =  Arrays.stream(fields)
                        .filter(f -> Modifier.toString(f.getModifiers())
                                .equalsIgnoreCase(finalInput)).toArray(Field[]::new);

                printFields(fieldsToPrint);
            }

		    input = scanner.nextLine();
        }
	}

    private static void printFields(Field[] fieldsToPrint) {
        Arrays.stream(fieldsToPrint).forEach(f -> System.out.println(String.format("%s %s %s",
                Modifier.toString(f.getModifiers()),
                f.getType().getSimpleName(),
                f.getName())));
    }
}
