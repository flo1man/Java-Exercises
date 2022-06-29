import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = Integer.parseInt(sc.nextLine());

        if (num >= -100 && num <= 100){
            System.out.println("Good job");
        }
        else {
            System.out.println("Wrong answer");
        }
    }
}
