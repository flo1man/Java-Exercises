import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder();

        while (!input.equals("end")){
            String[] tokens = input.split(" ");
            String command = tokens[0];
            String value = tokens[1];

            if (command.equals("Contains")){
                sb.append(numbers
                        .contains((Object)Integer.parseInt(value))
                        ? "Yes"
                        : "No such number");
            }
            else if (command.equals("Print")){
                if (value.equals("even")){
                    printNumbers(numbers.stream().filter(x -> x % 2 == 0).toList(), sb);
                }
                else {
                    printNumbers(numbers.stream().filter(x -> x % 2 != 0).toList(), sb);
                }
            }
            else if (command.equals("Get")){
                sb.append(numbers.stream().mapToInt(x -> x).sum());
            }
            else {
                int number = Integer.parseInt(tokens[2]);
                if (value.equals("<")) {
                    printNumbers(numbers.stream().filter(x -> x < number ).collect(Collectors.toList()), sb);
                }
                else if (value.equals("<=")) {
                    printNumbers(numbers.stream().filter(x -> x <= number ).collect(Collectors.toList()), sb);
                }
                else if (value.equals(">")) {
                    printNumbers(numbers.stream().filter(x -> x > number ).collect(Collectors.toList()), sb);
                }
                else {
                    printNumbers(numbers.stream().filter(x -> x >= number ).collect(Collectors.toList()), sb);
                }
            }
            System.out.println();
            input = scanner.nextLine();
        }

        System.out.println(sb);
    }

    private static void printNumbers(List<Integer> numbers, StringBuilder sb){
        List<String> list = numbers.stream()
                .map(x -> x.toString())
                .collect(Collectors.toList());

        sb.append(String.join(" ", list));
    }
}
