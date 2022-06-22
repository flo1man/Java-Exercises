import java.util.Arrays;
import java.util.Scanner;

public class EvenOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(x -> Integer.parseInt(x))
                .toArray();

        int evenSum = 0;
        int oddSum = 0;

        for (var num:
             numbers) {
            if (num % 2 == 0){
                evenSum += num;
            }
            else {
                oddSum += num;
            }
        }

        System.out.println(evenSum - oddSum);
    }
}
