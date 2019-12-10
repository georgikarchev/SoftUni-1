import java.util.*;

public class Socks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> leftSocks = new ArrayDeque<>();
        ArrayDeque<Integer> rightSocks = new ArrayDeque<>();
        List<Integer> pairedSockes = new ArrayList<>(0);

        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).forEach(leftSocks::push);
        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).forEach(rightSocks::offer);

        while(leftSocks.size() > 0 && rightSocks.size() > 0){
            Integer leftsock = leftSocks.peek();
            Integer righsock = rightSocks.peek();

            if (leftsock > righsock){
                pairedSockes.add(leftsock + righsock);
                leftSocks.pop();
                rightSocks.poll();
            }else if (righsock > leftsock){
                leftSocks.pop();
            }else{
                rightSocks.poll();
                leftSocks.pop();
                leftSocks.push(leftsock + 1);
            }
        }

        System.out.println(Collections.max(pairedSockes));
        pairedSockes.forEach(s -> System.out.print(s + " "));
    }
}
