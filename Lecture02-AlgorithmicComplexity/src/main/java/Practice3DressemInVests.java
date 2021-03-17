import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practice3DressemInVests {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noSoldier = scanner.nextInt();
        int noVest = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        int[] soldier = new int[noSoldier];
        for (int i = 0; i < noSoldier; i++) {
            soldier[i] = scanner.nextInt();
        }

        int[] vest = new int[noVest];
        for (int i = 0; i < noVest; i++) {
            vest[i] = scanner.nextInt();
        }

        int currentSoldier = 0;
        List<Pair> equippedData = new ArrayList<>();
        for (int currentVest = 0; currentVest < noVest; currentVest++) {
            while (currentSoldier < noSoldier) {
                if (vest[currentVest] >= soldier[currentSoldier] - x && vest[currentVest] <= soldier[currentSoldier] + y) {
                    equippedData.add(Pair.of(currentSoldier + 1, currentVest + 1));
                    currentSoldier++;
                    break;
                } else if (vest[currentVest] < soldier[currentSoldier] - x) {
                    break;
                } else {
                    currentSoldier++;
                }
            }
        }

        System.out.println(equippedData.size());
        for (Pair equipped : equippedData) {
            System.out.println(equipped.left + " " + equipped.right);
        }
    }

    private static class Pair {
        public int left;
        public int right;

        Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public static Pair of(int left, int right) {
            return new Pair(left, right);
        }
    }
}
