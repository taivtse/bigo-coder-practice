import java.util.ArrayList;
import java.util.Scanner;

public class Practice4Array {
    static final int MAX = 100001;
    static int[] frequency = new int[MAX];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nOfNumber = scanner.nextInt();
        int expectDistinct = scanner.nextInt();

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < nOfNumber; i++) {
            numbers.add(scanner.nextInt());
        }

        int unique = 0;
        int j = 0;
        for (int i = 0; i < nOfNumber; i++) {
            if (frequency[numbers.get(i)] == 0) {
                unique++;
            }
            frequency[numbers.get(i)]++;

            while (unique == expectDistinct) {
                frequency[numbers.get(j)]--;
                if (frequency[numbers.get(j)] == 0) {
                    System.out.printf("%d %d", j + 1, i + 1);
                    return;
                }

                j++;
            }
        }

        System.out.print("-1 -1");
    }
}
