import java.util.Scanner;

public class ReverseStringArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(" ");
        String[] reversedArr = new String[arr.length];
        int counter = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            reversedArr[counter] = arr[i];
            counter++;
        }

        System.out.println(String.join(" ", reversedArr));
    }
}
