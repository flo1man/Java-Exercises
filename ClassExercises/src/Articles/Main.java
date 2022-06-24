package Articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        Article article = new Article(input[0], input[1], input[2]);

        Integer n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(": ");
            String command = tokens[0];
            String value = tokens[1];

            if (command.equals("Edit")){
                article.edit(value);
            }
            else if (command.equals("ChangeAuthor")){
                article.changeAuthor(value);
            }
            else {
                article.rename(value);
            }
        }

        System.out.println(article);
    }
}
