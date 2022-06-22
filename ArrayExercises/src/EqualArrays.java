import javax.management.OperationsException;
import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstArr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(x -> Integer.parseInt(x))
                .toArray();

        int[] secondArr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(x -> Integer.parseInt(x))
                .toArray();

        for (int i = 0; i < firstArr.length; i++) {
            try {
                if (firstArr[i] != secondArr[i]){
                    throw new OperationsException();
                }
            }
            catch (Exception e){
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                return;
            }
        }
        int sum = Arrays.stream(firstArr).sum();
        System.out.printf("Arrays are identical. Sum: %d", sum);
    }
}
