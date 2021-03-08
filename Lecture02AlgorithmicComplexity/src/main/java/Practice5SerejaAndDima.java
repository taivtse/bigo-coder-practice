import java.util.Scanner;

public class Practice5SerejaAndDima {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nOfCard = scanner.nextInt();

        int[] cards = new int[nOfCard];
        for (int i = 0; i < nOfCard; i++) {
            cards[i] = scanner.nextInt();
        }

        int serejaScore = 0;
        int dimaScore = 0;
        int left = 0;
        int right = nOfCard - 1;
        while (left < right) {
            // sereja pick
            if (cards[left] > cards[right]) {
                serejaScore += cards[left];
                left++;
            } else if (cards[right] > cards[left]) {
                serejaScore += cards[right];
                right--;
            }

            // dima pick
            if (cards[left] > cards[right]) {
                dimaScore += cards[left];
                left++;
            } else if (cards[right] > cards[left]) {
                dimaScore += cards[right];
                right--;
            }
        }

        // last card
        if (nOfCard % 2 == 0) {
            dimaScore += cards[left];
        } else {
            serejaScore += cards[left];
        }

        System.out.println(serejaScore + " " + dimaScore);
    }
}
