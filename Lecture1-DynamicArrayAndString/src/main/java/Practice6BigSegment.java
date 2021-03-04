import java.util.Scanner;

public class Practice6BigSegment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nOfSegment = scanner.nextInt();

        int minL = Integer.MAX_VALUE;
        int maxR = Integer.MIN_VALUE;
        int[][] segments = new int[nOfSegment][2];
        for (int i = 0; i < nOfSegment; i++) {
            int lVal = scanner.nextInt();
            int rVal = scanner.nextInt();
            minL = Math.min(minL, lVal);
            maxR = Math.max(maxR, rVal);

            segments[i][0] = lVal;
            segments[i][1] = rVal;
        }

        int bigSegRow = -1;
        for (int i = 0; i < nOfSegment; i++) {
            if (segments[i][0] == minL && segments[i][1] == maxR) {
                bigSegRow = i + 1;
                break;
            }
        }

        System.out.println(bigSegRow);
    }
}
