package pr02PrivateClassFiddling;

import pr02PrivateClassFiddling.com.BlackBoxInt;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();

		Constructor<BlackBoxInt> constructor = BlackBoxInt.class.getDeclaredConstructor();
		constructor.setAccessible(true);

		BlackBoxInt blackBox = constructor.newInstance();
		Method[] methods = blackBox.getClass().getDeclaredMethods();
		Field innerValue = blackBox.getClass().getDeclaredField("innerValue");
		innerValue.setAccessible(true);

		while(!input.equals("END")){
			String[] tokens = input.split("_");
			String operation = tokens[0];
			int number = Integer.parseInt(tokens[1]);

			Method method = Arrays.stream(methods).filter(m -> m.getName().equals(operation))
					.findFirst().orElse(null);

			method.setAccessible(true);
			method.invoke(blackBox, number);
			System.out.println(innerValue.get(blackBox));

			input = scanner.nextLine();
		}
	}
}
