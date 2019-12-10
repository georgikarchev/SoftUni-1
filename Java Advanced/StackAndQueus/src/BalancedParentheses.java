import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String parantheses = scanner.nextLine();

        if(isBalanced(parantheses)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }

    private static boolean isBalanced(String parantheses) {

        Deque<Character> openingParantheses = new ArrayDeque<>();

        for (int i = 0; i < parantheses.length(); i++) {
            char singlePparantheses = parantheses.charAt(i);
            if(singlePparantheses == ')'){
                if(openingParantheses.isEmpty()){
                    return false;
                }
                char opening = openingParantheses.pop();
                if(opening != '('){
                    return false;
                }
            }else if(singlePparantheses == ']'){
                if(openingParantheses.isEmpty()){
                    return false;
                }
                char opening = openingParantheses.pop();
                if(opening != '['){
                    return false;
                }
            }else if(singlePparantheses == '}'){
                if(openingParantheses.isEmpty()){
                    return false;
                }
                char opening = openingParantheses.pop();
                if(opening != '{'){
                    return false;
                }
            }else{
                openingParantheses.push(singlePparantheses);
            }
        }

        return true;
    }
}