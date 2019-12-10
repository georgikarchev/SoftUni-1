import java.util.ArrayDeque;
import java.util.Scanner;

public class InternShip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfProblems = Integer.parseInt(scanner.nextLine());
        int numberOfCandidates = Integer.parseInt(scanner.nextLine());
        String problem;
        String candidate;

        ArrayDeque<String> problemsStack = new ArrayDeque<>();
        ArrayDeque<String> candidatesQueue = new ArrayDeque<>();

        for (int i = 0; i < numberOfProblems; i++) {
            problem = scanner.nextLine();
            problemsStack.push(problem);
        }

        for (int i = 0; i < numberOfCandidates ; i++) {
            candidate = scanner.nextLine();
            if(candidate.matches("^[A-Z][a-zA-Z']+[ ]+[A-Z][a-zA-Z'\\- ]*$")){
                candidatesQueue.offer(candidate);
            }
        }

        while(problemsStack.size() != 0 && candidatesQueue.size() != 1){
            candidate = candidatesQueue.peek();
            problem = problemsStack.peek();

            int candidateValue = sumOfLetters(candidate);
            int problemValue = sumOfLetters(problem);

            if(candidateValue > problemValue ){
                problemsStack.pop();
                candidatesQueue.poll();
                candidatesQueue.offer(candidate);
                System.out.println(candidate + " solved " + problem + ".");
            }else {
                problemsStack.pop();
                problemsStack.offer(problem);
                candidatesQueue.pop();
                System.out.println(candidate + " failed " + problem+ ".");

            }
        }

        printTheResult(candidatesQueue);
        System.out.println();
    }

    private static void printTheResult(ArrayDeque<String> candidatesQueue) {
        if(candidatesQueue.size() == 1){
            System.out.println(candidatesQueue.peek() + " gets the job!");
        }else{
            System.out.println(String.join(", ", candidatesQueue));
        }
    }

    private static int sumOfLetters(String string) {
        char[] stringArray = string.toCharArray();
        int sum = 0;

        for (int i = 0; i <  stringArray.length; i++) {
            char singleChar = stringArray[i];
            int charNum = (int) singleChar;
            sum+= charNum;
        }
        return sum;
    }
}