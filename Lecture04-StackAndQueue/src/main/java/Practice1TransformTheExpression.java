import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Practice1TransformTheExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        List<String> expressions = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            String expression = scanner.nextLine();
            if ("".equals(expression)) {
                i--;
                continue;
            }
            expressions.add(expression);
        }

        expressions.forEach(Practice1TransformTheExpression::transform);
    }

    public static void transform(String expression) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);
            if (Character.isLetter(symbol)) {
                System.out.print(symbol);
            } else if (symbol == ')') {
                System.out.print(s.pop());
            } else if (symbol != '(') {
                s.push(symbol);
            }
        }
        System.out.println();
    }
}
