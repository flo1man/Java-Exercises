import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ListOfProducts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> products = new ArrayList<>();
        Integer num = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < num; i++) {
            String product = scanner.nextLine();
            products.add(product);
        }

        // Sort list
        Collections.sort(products);
        System.out.println("\n");
        for (int i = 0; i < products.size(); i++) {
            System.out.printf("%d.%s%n",i + 1, products.get(i));
        }
    }
}
