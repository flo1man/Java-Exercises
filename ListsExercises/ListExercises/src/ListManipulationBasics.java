import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")){
            String[] tokens = input.split("\\s|\s");
            String command = tokens[0];
            int value = Integer.parseInt(tokens[1]);

            if (command.equals("Add")){
                numbers.add(value);
            }
            else if(command.equals("Remove")){
                numbers.remove((Object)value);
            }
            else if(command.equals("RemoveAt")){
                numbers.remove(value);
            }
            else {
                int index = Integer.parseInt(tokens[2]);
                numbers.add(index,value);
            }

            input = scanner.nextLine();
        }
        printList(numbers);
    }

    private static void printList(List<Integer> numbers) {
        List<String> list = numbers.stream()
                .map(x -> x.toString())
                .collect(Collectors.toList());

        System.out.println(String.join(" ", list));
    }
}
