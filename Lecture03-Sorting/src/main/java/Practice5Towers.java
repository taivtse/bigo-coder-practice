import java.util.*;

public class Practice5Towers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nOfBar = scanner.nextInt();
        List<Integer> bars = new ArrayList<>(nOfBar);
        for (int i = 0; i < nOfBar; i++) {
            bars.add(scanner.nextInt());
        }

        int[] height = new int[1001];
        int totalBars = 0;
        int highest = 0;
        for (Integer bar : bars) {
            if (height[bar] == 0) {
                totalBars++;
            }
            height[bar]++;
            highest = Math.max(highest, height[bar]);
        }

        System.out.println(highest + " " + totalBars);
    }
}
