import java.util.Scanner;

public class Practice6BigSegment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nOfSegment = scanner.nextInt();

        int minL = 0;
        int maxR = 0;
        int bigSegRow = -1;
        for (int i = 0; i < nOfSegment; i++) {
            int lVal = scanner.nextInt();
            int rVal = scanner.nextInt();

            if (bigSegRow == -1) {
                if (i == 0) {
                    minL = lVal;
                    maxR = rVal;
                }
                if (i == nOfSegment -1) {
                    boolean isNewBigSeg = lVal <= minL && maxR <= rVal;
                    if (isNewBigSeg) {
                        bigSegRow = nOfSegment - 1;
                    } else {
                        bigSegRow = -1;
                    }
                    break;
                }

                minL = Math.min(lVal, minL);
                maxR = Math.max(rVal, maxR);
                bigSegRow = i + 1;
                continue;
            }

            boolean isCurBigSegValid = minL <= lVal && rVal <= maxR;
            if (isCurBigSegValid) {
                continue;
            }

            boolean isNewBigSeg = lVal <= minL && maxR <= rVal;
            if (isNewBigSeg) {
                minL = lVal;
                maxR = rVal;
                bigSegRow = i + 1;
            } else {
                minL = Math.min(lVal, minL);
                maxR = Math.max(rVal, maxR);
                bigSegRow = -1;
            }
        }

        System.out.println(bigSegRow);
    }
}
