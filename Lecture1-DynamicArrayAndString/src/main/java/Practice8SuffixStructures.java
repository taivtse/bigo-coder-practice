import java.util.Scanner;

public class Practice8SuffixStructures {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();

        int[] digitSCount = new int[26];
        char[] charSArr = s.toCharArray();
        for (char charInS : charSArr) {
            int pos = getPosOf(charInS);
            digitSCount[pos]++;
        }

        int[] digitTCount = new int[26];
        char[] charTArr = t.toCharArray();
        for (char charInT : charTArr) {
            int pos = getPosOf(charInT);
            digitTCount[pos]++;
        }

        boolean isNeedTree = false;
        boolean isAutomation = false;
        for (int i = 0; i < digitSCount.length; i++) {
            int charInSCount = digitSCount[i];
            int charInTCount = digitTCount[i];

            if (charInTCount > charInSCount) {
                isNeedTree = true;
            }
            if (charInTCount < charInSCount) {
                isAutomation = true;
            }
        }

        boolean isArray = false;
        int lastFoundIndex = -1;
        for (int i = 0; i < charTArr.length; i++) {
            char charInT = charTArr[i];
            int nextFoundIndex = s.indexOf(charInT, lastFoundIndex + 1);
            if (nextFoundIndex == -1) {
                isArray = true;
                break;
            } else {
                lastFoundIndex = nextFoundIndex;
            }
        }

        if (isNeedTree) {
            System.out.println("need tree");
        } else if (isAutomation && isArray) {
            System.out.print("both");
        } else if (isAutomation) {
            System.out.print("automaton");
        } else {
            System.out.print("array");
        }
    }

    private static int getPosOf(char c) {
        return c - 'a';
    }

}
