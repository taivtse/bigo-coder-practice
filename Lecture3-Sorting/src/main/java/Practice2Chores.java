import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Practice2Chores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nOfChores = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        List<Integer> chores =  new ArrayList<>();
        for (int i = 0; i < nOfChores; i++) {
            chores.add(scanner.nextInt());
        }

        Collections.sort(chores);

        System.out.println(chores.get(b) - chores.get(b -1));
    }
}
