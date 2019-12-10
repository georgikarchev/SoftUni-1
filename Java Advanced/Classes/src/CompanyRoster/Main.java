package CompanyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countOfEmployee = Integer.parseInt(reader.readLine());

        List<Employee> employees = new ArrayList<>();

        while (countOfEmployee-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");

            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            Employee employee = null;
            switch (tokens.length) {
                case 4:
                    employee = new Employee(name, salary, position, department);
                    break;
                case 5:
                    if (tokens[4].matches("\\d+")) {
                        int age = Integer.parseInt(tokens[4]);
                        employee = new Employee(name, salary, position, department, age);
                    } else {
                        String email = tokens[4];
                        employee = new Employee(name, salary, position, department, email);
                    }
                    break;
                case 6:
                    String email = tokens[4];
                    int age = Integer.parseInt(tokens[5]);
                    employee = new Employee(name, salary, position, department, email, age);
                    break;
            }

            employees.add(employee);
        }

        Map.Entry<String, List<Employee>> department = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing((Map.Entry<String, List<Employee>> d) -> d.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble(), Comparator.reverseOrder()))
                .findFirst()
                .orElse(null);

        StringBuilder result = new StringBuilder();
        result.append(String.format("Highest Average Salary: %s", department.getKey())).append(System.lineSeparator());

        department.getValue().stream()
                .sorted(Comparator.comparing(Employee::getSalary, Comparator.reverseOrder()))
                .forEach(e -> result.append(e).append(System.lineSeparator()));

        System.out.println(result.toString());

    }
}
