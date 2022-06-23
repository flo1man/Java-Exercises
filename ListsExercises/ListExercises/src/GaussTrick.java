import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> list = new ArrayList<>();
        boolean isSizeEven = false;

        if (numbers.size() % 2 == 0){
            isSizeEven = true;
        }
        for (int i = 0; i < numbers.size() / 2; i++) {
            int sum = numbers.get(i) + numbers.get(numbers.size() - 1 - i);
            list.add(sum);
        }
        if (!isSizeEven){
            list.add(numbers.get(numbers.size() / 2));
        }

        String output = joinElementsByDelimiter(list, " ");
        System.out.println(output);
    }

    private static String joinElementsByDelimiter(List<Integer> numbers, String delimiter) {
        String output = "";
        for (int i = 0; i < numbers.size(); i++) {
            output +=  numbers.get(i) + delimiter;
        }

        return  output.trim();
    }
}
