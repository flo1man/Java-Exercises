import java.util.*;

public class BrowserHistory {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<String> stack = new ArrayDeque<>();*/
        ArrayDeque<String> a = new ArrayDeque<>();
        a.push("one");
        a.push("two");
        a.push("three");
        a.push("four");
        System.out.println(String.join(" ", a));
        Queue<String> s = new ArrayDeque<>();
        s.add("one");
        s.add("two");
        s.add("three");
        s.add("four");
        System.out.println(String.join(" ", s));
        /*while (!input.equals("Home")){

            if (input.equals("back")){
                if (stack.size() >= 2){
                    stack.pop();
                    System.out.println(stack.peek());
                }
                else {
                    System.out.println("no previous URLs");
                }
            }
            else {
                stack.push(input);
                System.out.println(input);
            }

            input = scanner.nextLine();
        }*/
    }
}
