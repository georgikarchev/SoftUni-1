import java.util.*;

public class FirstProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxCapacity = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(" ");
        int sumOfPeople = 0;

        ArrayDeque<String> hallsAndNums = new ArrayDeque<>();
        ArrayDeque<String> halls = new ArrayDeque<>();
        String numbers = "";

        for (int i = 0; i < input.length; i++) {
            hallsAndNums.push(input[i]);
        }

int count = hallsAndNums.size();
        for (int i = 0; i <count; i++) {
            if(halls.isEmpty()) {
                if (!isNumeric(halls, hallsAndNums)) {
                    String hall = hallsAndNums.pop();
                    halls.offer(hall);
                }
            } else {
                if (!isNumeric(hallsAndNums, halls)) {
                    String hall = hallsAndNums.pop();
                    halls.offer(hall);
                }else {
                    int people = Integer.parseInt(hallsAndNums.pop());
                    if (maxCapacity >= sumOfPeople + people) {
                        String peopleString = String.valueOf(people);

                        if(numbers.equals("")){
                            numbers = peopleString;
                        }else{
                            numbers +=  ", " + people;
                        }
                        sumOfPeople += people;
                    } else {
                        System.out.println(halls.pop() + " -> " + numbers);
                        numbers = String.valueOf(people);
                        if(halls.isEmpty()){
                            continue;
                        }else{
                            sumOfPeople = people;
                        }

                    }
                }
            }


        }


    }
    public static boolean isNumeric(ArrayDeque<String> halls, ArrayDeque<String> numbers)
    {
        try
        {
            double d = Double.parseDouble(numbers.peek());
        }
        catch(NumberFormatException nfe)
        {

            return false;
        }

        if(halls.isEmpty()){
            numbers.pop();
        }
        return true;
    }
}
