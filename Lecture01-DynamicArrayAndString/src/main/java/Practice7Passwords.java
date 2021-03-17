import java.util.Scanner;

/**
 * @author taivt
 * @since 2021/03/04 17:14:38
 */
public class Practice7Passwords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nTimes = scanner.nextInt();
        int limitInvalidTimes = scanner.nextInt();
        int[] lengthCountArr = new int[101];

        for (int i = 0; i < nTimes; i++) {
            String line = scanner.nextLine();
            if ("".equals(line)) {
                i -= 1;
                continue;
            }
            lengthCountArr[line.length()]++;
        }

        int minTime = 0;
        int maxTime = 0;
        String password = scanner.nextLine();
        for (int i = 0; i < password.length(); i++) {
            minTime += lengthCountArr[i];
        }

        maxTime = minTime + lengthCountArr[password.length()] - 1;
        minTime += (minTime / limitInvalidTimes) * 5;
        maxTime += (maxTime / limitInvalidTimes) * 5;

        System.out.print((minTime + 1) + " " + (maxTime + 1));
    }
}
