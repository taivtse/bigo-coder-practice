import java.util.Scanner;

public class Practice1Books {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nOfBook = scanner.nextInt();
        int freeTime = scanner.nextInt();

        int [] estimatedTimes = new int[nOfBook];
        for (int i = 0; i < nOfBook; i++) {
            estimatedTimes[i] = scanner.nextInt();
        }

        int maxBooksCount = 0;
        for (int i = 0; i < nOfBook; i++) {

            int readTime = 0;
            int bookCount = 0;
            for (int j = i; j < nOfBook; j++) {
                int estimatedTime = estimatedTimes[j];
                readTime += estimatedTime;
                if (readTime <= freeTime) {
                    bookCount++;
                } else {
                    break;
                }
            }

            if (bookCount > maxBooksCount) {
                maxBooksCount = bookCount;
            }
        }

        System.out.println(maxBooksCount);
    }
}
