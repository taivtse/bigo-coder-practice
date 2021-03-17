import java.util.*;
import java.util.stream.Collectors;

public class Practice3ThrowingCardsAwayI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n == 0) {
                return;
            }
            evaluate(n);
        }
    }

    private static void evaluate(int n) {
        List<Integer> discards = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            Integer first = queue.poll();
            discards.add(first);

            Integer second = queue.poll();
            queue.add(second);
        }

        String discardsCards = discards.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        if (!discardsCards.isEmpty()) {
            discardsCards = " " + discardsCards;
        }
        System.out.println("Discarded cards:" + discardsCards);
        System.out.println("Remaining card: " + queue.poll());
    }
}
