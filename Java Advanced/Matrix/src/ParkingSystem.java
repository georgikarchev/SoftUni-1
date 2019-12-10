import java.util.*;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, ArrayList<Integer>> parkingSpots = new LinkedHashMap<>();

        int[] dimension = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimension[0];
        int cols = dimension[1];

        for (int row = 0; row < rows; row++) {
            parkingSpots.put(row, new ArrayList<>() { {add(0); }});
        }

        String command = scanner.nextLine();

        while (!command.equals("stop")){
            int[] target = Arrays.stream(command.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int entryRow = target[0];
            int targetRow = target[1];
            int targetCol = target[2];

            if (!parkingSpots.get(targetRow).contains(targetCol)){
                parkingSpots.get(targetRow).add(targetCol);

                int totalSteps = Math.abs(entryRow - targetRow) + targetCol + 1;
                System.out.println(totalSteps);
            }
            else if (parkingSpots.get(targetRow).size() == cols){
                System.out.println(String.format("Row %d full", targetRow));
            }
            else {
                int counter = 1;

                while (true){
                    int spot = targetCol - counter;

                    if (!parkingSpots.get(targetRow).contains(spot) && spot > 0){
                        parkingSpots.get(targetRow).add(spot);
                        int totalSteps = Math.abs(entryRow - targetRow) + spot + 1;
                        System.out.println(totalSteps);
                        break;
                    }

                    spot = targetCol + counter;

                    if (!parkingSpots.get(targetRow).contains(spot) && spot < cols){
                        parkingSpots.get(targetRow).add(spot);
                        int totalSteps = Math.abs(entryRow - targetRow) + spot + 1;
                        System.out.println(totalSteps);
                        break;
                    }

                    counter++;
                }
            }
            command = scanner.nextLine();
        }
    }
}