import java.util.*;

public class Practice4GukiZAndContest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ratings = new int[n];
        for (int i = 0; i < n; i++) {
            ratings[i] = scanner.nextInt();
        }

        Map<Integer, Integer> rank = new TreeMap<>(Collections.reverseOrder());
        for (Integer rating : ratings) {
            Integer count = rank.get(rating);
            if (count == null) {
                count = 0;
            }
            count++;
            rank.put(rating, count);
        }

        int totalRank = 1;
        for (Map.Entry<Integer, Integer> entry : rank.entrySet()) {
            Integer count = entry.getValue();
            entry.setValue(totalRank);
            totalRank = totalRank + count;
        }

        for (int rating : ratings) {
            System.out.printf("%s ", rank.get(rating));
        }
    }
}
