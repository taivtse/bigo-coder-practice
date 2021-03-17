import java.util.*;

public class Practice4ThatIsYourQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = 1;
        while (scanner.hasNext()) {
            int p = scanner.nextInt();
            int c = scanner.nextInt();
            if (p == 0 && c == 0) {
                return;
            }
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 1; i <= Math.min(p, c); i++) {
                deque.add(i);
            }

            System.out.printf("Case %s:%n", cases++);
            for (int i = 0; i < c; i++) {
                String command = scanner.next();
                if (command.equals("N")) {
                    Integer poll = deque.poll();
                    System.out.println(poll);
                    deque.add(poll);
                } else {
                    Integer expedited = scanner.nextInt();
                    deque.remove(expedited);
                    deque.addFirst(expedited);
                }
            }
        }
    }
}
