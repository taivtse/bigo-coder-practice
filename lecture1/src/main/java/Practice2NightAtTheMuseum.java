import java.util.Scanner;

public class Practice2NightAtTheMuseum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = "a" + scanner.nextLine();

        int total = 0;
        for (int i = 0; i < word.length(); i++) {
            if (i == word.length() - 1) {
                break;
            }

            char curChar = word.charAt(i);
            char nextChar = word.charAt(i + 1);
            int step = Math.abs(curChar - nextChar);
            if (step > 12) {
                step = 26 - step;
            }
            total += step;
        }

        System.out.println(total);
    }
}
