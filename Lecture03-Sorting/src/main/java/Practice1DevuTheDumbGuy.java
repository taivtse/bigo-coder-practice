import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Practice1DevuTheDumbGuy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nOfSubjects = scanner.nextInt();
        int timePerChap = scanner.nextInt();

        List<Integer> subjects =  new ArrayList<>();
        for (int i = 0; i < nOfSubjects; i++) {
            subjects.add(scanner.nextInt());
        }

        Collections.sort(subjects);

        long totalTime = 0;
        for (Integer nOfChapter : subjects) {
            totalTime += ((long) nOfChapter * timePerChap);
            if (timePerChap > 1) {
                timePerChap--;
            }
        }

        System.out.println(totalTime);
    }
}
