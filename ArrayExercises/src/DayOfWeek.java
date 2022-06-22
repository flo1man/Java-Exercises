import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] daysOfWeek = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int input = Integer.parseInt(scanner.nextLine());

        try {
            System.out.println(daysOfWeek[input - 1]);
        }
        catch (Exception e){
            System.out.println("Invalid day!");
        }
    }
}
