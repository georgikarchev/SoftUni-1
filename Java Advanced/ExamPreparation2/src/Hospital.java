import java.util.*;

public class Hospital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        HashMap<String, String[]> departments = new HashMap<>();
        HashMap<String, TreeSet<String>> patientsOfADoctor = new HashMap<>();


        while (!input[0].equals("Output")){
            String department = input[0];
            String doctor = input[1] + " " + input[2] ;
            String patient = input[3];

            if(!departments.containsKey(department)){
                departments.put(department, new String[60]);
            }

            for (int i = 0; i < departments.get(department).length; i++) {
                if(departments.get(department)[i] == null ){
                    departments.get(department)[i] = patient;
                    break;
                }
            }

            if(!patientsOfADoctor.containsKey(doctor)){
                patientsOfADoctor.put(doctor, new TreeSet<>());
            }

            patientsOfADoctor.get(doctor).add(patient);

            input = scanner.nextLine().split(" ");
        }

        input = scanner.nextLine().split(" ");

        while(!input[0].equals("End")){
            String checker = input[0];

            if(departments.containsKey(checker)){
                String finalDepartment = input[0];
                if(input.length > 1){
                    int room = Integer.parseInt(input[1]);
                    int endBeds = room * 3;
                    int startBeds = endBeds- 3;
                    ArrayList<String> patientsInARoom = new ArrayList<>();

                    for (int i = startBeds; i < endBeds; i++) {
                        patientsInARoom.add(departments.get(finalDepartment)[i]);
                    }
                    Collections.sort(patientsInARoom);
                    for (String patient:patientsInARoom) {
                        System.out.println(patient);
                    }


                }else{
                    if(departments.containsKey(finalDepartment)){
                        for (String patient:departments.get(finalDepartment)) {
                            if(patient != null){
                                System.out.println(patient);
                            }
                        }
                    }
                }

            }else{
                String doctorName = checker + " " + input[1];
                
                if(patientsOfADoctor.containsKey(doctorName)){
                    for (String patient:patientsOfADoctor.get(doctorName)) {
                        System.out.println(patient);
                    }
                }
            }

            input = scanner.nextLine().split(" ");
        }
    }
}