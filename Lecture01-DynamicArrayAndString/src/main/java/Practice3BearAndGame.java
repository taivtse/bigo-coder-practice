import java.util.Scanner;

public class Practice3BearAndGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int interestingMinutes = scanner.nextInt();

        int totalMinutes = 0;
        int curMinutes = 0;
        boolean isStopSuddenly = false;
        for (int i = 0; i < interestingMinutes; i++) {
            int interestingAt = scanner.nextInt();
            if (interestingAt - curMinutes > 15) {
                totalMinutes += 15;
                isStopSuddenly = true;
                break;
            }

            totalMinutes += (interestingAt - curMinutes);
            curMinutes = interestingAt;
        }

        if (!isStopSuddenly) {
            if (curMinutes + 15 <= 90) {
                totalMinutes += 15;
            }else {
                totalMinutes = 90;
            }
        }

        System.out.println(totalMinutes);
    }
}
