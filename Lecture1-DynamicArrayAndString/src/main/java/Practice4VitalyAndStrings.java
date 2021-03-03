import java.util.Scanner;

public class Practice4VitalyAndStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stringS = scanner.nextLine();
        String stringT = scanner.nextLine();
        int length = stringS.length();

        int diffPos = 0;
        for (int i = 0; i < length; i++) {
            char charAtS = stringS.charAt(i);
            char charAtT = stringT.charAt(i);

            if (charAtS == charAtT) {
                continue;
            }

            diffPos = i;
            break;
        }

        char[] outputArr = stringS.toCharArray();
        for (int i = length - 1; i >= diffPos; i--) {
            char charAtS = stringS.charAt(i);

            charAtS++;
            boolean isStillLetter = Character.isLetter(charAtS);
            if (isStillLetter) {
                outputArr[i] = charAtS;
                break;
            }
            charAtS = 'a';
            outputArr[i] = charAtS;
        }

        String output = new String(outputArr);
        if (output.compareTo(stringT) >= 0) {
            output = "No such string";
        }


        System.out.println(output);

    }
}