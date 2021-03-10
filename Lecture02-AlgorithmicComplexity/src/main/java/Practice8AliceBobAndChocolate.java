import java.util.Scanner;

public class Practice8AliceBobAndChocolate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nOfBar = scanner.nextInt();
        int[] bars = new int[nOfBar];

        for (int i = 0; i < nOfBar; i++) {
            bars[i] = scanner.nextInt();
        }

        int aliceEating = 0;
        int bobEating = nOfBar - 1;
        int aliceTime = 0;
        int bobTime = 0;
        while (aliceEating <= bobEating) {
            if (aliceEating == bobEating && aliceTime <= bobTime) {
                aliceEating++;
                break;
            }

            if (aliceTime == bobTime) {
                aliceTime += bars[aliceEating];
                bobTime += bars[bobEating];

                aliceEating++;
                bobEating--;
            } else if (aliceTime < bobTime) {
                aliceTime += bars[aliceEating];
                aliceEating++;
            } else {
                bobTime += bars[bobEating];
                bobEating--;
            }
        }

        System.out.println((aliceEating) + " " + (nOfBar - bobEating - 1));
    }
}
