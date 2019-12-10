import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CinemaTickets {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] names = bf.readLine().split(", ");
        ArrayList<String> unsavedPeople = new ArrayList<>();
        HashMap<Integer, String> reservedPlaces = new HashMap<>();

        String input = bf.readLine();

        while (!input.equals("generate")){
            String name = input.split(" - ")[0];
            Integer placeWanted = Integer.valueOf(input.split(" - ")[1]);

            Swap(Arrays.asList(names).indexOf(name), placeWanted - 1, names);
            reservedPlaces.put(placeWanted - 1, name);

            input = bf.readLine();
        }
        for (int i = 0; i <names.length ; i++) {
            if(!(reservedPlaces.containsValue(names[i]))){
                unsavedPeople.add(names[i]);
            }
        }
        swapUnsavedPlaces(unsavedPeople, 0, reservedPlaces);
    }

    private static void swapUnsavedPlaces(ArrayList<String> names, int index, HashMap<Integer, String> reservedPlaces) {
     if(index == names.size()){
         printNames(names, reservedPlaces);
     }

        for (int i = index; i < names.size(); i++) {
            String temp = names.get(index);
            names.set(index, names.get(i));
            names.set(i, temp);
            swapUnsavedPlaces(names, index + 1, reservedPlaces);

            temp = names.get(index);
            names.set(index, names.get(i));
            names.set(i, temp);
        }
    }

    private static void printNames(ArrayList<String> names, HashMap<Integer, String> reservedPlaces) {
        String[] allNames = new String[names.size() + reservedPlaces.size()];
        int num = 0;
        for (int i = 0; i < allNames.length; i++) {
            if(reservedPlaces.containsKey(i)){
                allNames[i] = reservedPlaces.get(i);
                num++;
                continue;
            }

            allNames[i] = names.get(i - num);
        }
        System.out.println(String.join(" ", allNames));
    }

    private static void Swap(int name, Integer placeWanted, String[] names) {
        String temp = names[name];
        names[name] = names[placeWanted];
        names[placeWanted] = temp;
    }
}
