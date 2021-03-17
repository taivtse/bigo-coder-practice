import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Practice2StreetParade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n == 0) {
                return;
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                queue.add(scanner.nextInt());
            }
            evaluate(queue, n);
        }
    }

    private static void evaluate(Queue<Integer> queue, int n) {
        Stack<Integer> stack = new Stack<>();
        int order = 1;
        while (order <= n) {
            if (!stack.isEmpty()) {
                Integer peek = stack.peek();
                if (peek == order) {
                    stack.pop();
                    order++;
                    continue;
                } else if (queue.isEmpty()) {
                    System.out.println("no");
                    return;
                }
            }

            if (!queue.isEmpty()) {
                Integer poll = queue.poll();
                if (poll == order) {
                    order++;
                    continue;
                }
                stack.push(poll);
            }
        }

        System.out.println("yes");
    }
}
