import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class ShootingRace{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int[] values = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean[] marked = new boolean[values.length];
        int target = Integer.parseInt(bf.readLine());

        Generate(0, target, values, marked);
    }

    private static void Generate(int index, int target, int[] values, boolean[] marked) {
        int score = GetScore(values, marked);

        if(score == target){
            FinalPrint(values, marked);
        }

        if(index >= values.length || score >= target){
            return;
        }

        HashSet<Integer> swapped = new HashSet<>();

        for (int i = index; i < values.length ; i++) {
            if(!swapped.contains(values[i])){
                Swap(index, i, values);
                marked[index] = true;

                Generate(index + 1, target, values,marked);

                Swap(index, i, values);
                marked[index] = false;

                swapped.add(values[i]);
            }
        }
    }

    private static void Swap(int i, int j, int[] values) {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }

    private static void FinalPrint(int[] values, boolean[] marked) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length ; i++) {
            if(marked[i]){
                sb.append(values[i]).append(" ");
            }
        }

        System.out.println(sb.toString().trim());
    }

    private static int GetScore(int[] values, boolean[] marked) {
        int score = 0;
        int multiplier = 0;
        for (int i = 0; i < values.length; i++) {
            if (marked[i]) {
                score += values[i] * ++multiplier;
            }
        }
        return score;
    }
}