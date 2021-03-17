import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Practice7ProcessingQueries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int b = scanner.nextInt();

        Query[] queries = new Query[n];
        for (int i = 0; i < n; i++) {
            Query query = new Query();
            query.arrival = scanner.nextInt();
            query.execTime = scanner.nextInt();
            query.finishAt = 0;
            queries[i] = query;
        }

        Queue<Long> queue = new LinkedList<>();
        long time = queries[0].arrival + queries[0].execTime;
        queries[0].finishAt = time;
        queue.add(time);

        for (int i = 1; i < n; i++) {
            while (queue.size() > 0 && queries[i].arrival >= queue.peek()) {
                queue.poll();
            }

            if (time <= queries[i].arrival) {
                time = queries[i].arrival + queries[i].execTime;
                queries[i].finishAt = time;
                queue.add(time);
            } else {
                if (queue.size() > b) {
                    queries[i].finishAt = -1;
                } else {
                    time += queries[i].execTime;
                    queries[i].finishAt = time;
                    queue.add(time);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(queries[i].finishAt + " ");
        }
    }

    private static class Query {
        public long arrival;
        public long execTime;
        public long finishAt;

        public Query() {
        }
    }
}
