import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practice3SortTheArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> numbers = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        int startReverse = -1;
        int endReverse = -1;
        for (int i = 1; i < numbers.size(); i++) {
            Integer preNum = numbers.get(i - 1);
            Integer num = numbers.get(i);
            if (preNum < num) {
                continue;
            }

            startReverse = i - 1;
            endReverse = i;
            for (int j = i; j < n - 1; j++) {
                endReverse = j;
                if (numbers.get(j - 1) < numbers.get(j)) {
                    break;
                }
            }

            if (numbers.get(startReverse) > numbers.get(endReverse + 1) || numbers.get(startReverse - 1) > numbers.get(endReverse)) {
                System.out.println("no");
                return;
            }

            i = endReverse;
        }

        System.out.println((startReverse + 1) + " " + (endReverse + 1));
    }
}
