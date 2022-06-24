package Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Student> students = new ArrayList<>();

        while (!input.equals("end")){
            String[] tokens = input.split(" ");
            String firstName = tokens[0];
            String lastName = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            String homeTown = tokens[3];

            students.add(new Student(firstName, lastName, age, homeTown));

            input = scanner.nextLine();
        }

        String town = scanner.nextLine();

        for (var student : students.stream().filter(x -> x.getHomeTown().equals(town)).collect(Collectors.toList())){
            System.out.println(student.toString());
        }
    }
}
