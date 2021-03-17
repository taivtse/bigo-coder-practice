import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Practice8CompilersAndParsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        List<String> expressions = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            String expression = scanner.next();
            expressions.add(expression);
        }

        expressions.forEach(Practice8CompilersAndParsers::evaluate);
    }

    public static void evaluate(String expression) {
        Stack<Character> s = new Stack<>();
        int totalValid = 0;
        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);
            if (symbol == '<') {
                s.push(symbol);
            } else if (symbol == '>') {
                if (s.isEmpty()) {
                    break;
                }
                Character top = s.peek();
                if (top == '<') {
                    s.pop();
                }
                if (s.isEmpty()) {
                    totalValid = i + 1;
                }
            }
        }

        System.out.println(totalValid);
    }
}
