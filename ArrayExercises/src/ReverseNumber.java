import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCount = scanner.nextInt();
        int[] numbers = new int[numCount];

        for (int i = numCount - 1; i >= 0; i--) {
            int num = scanner.nextInt();
            numbers[i] = num;
        }

        for (var n:
             numbers) {
            System.out.print(n + " ");
        }
    }
}
