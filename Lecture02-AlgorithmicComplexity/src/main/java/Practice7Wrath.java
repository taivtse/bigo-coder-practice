import java.util.Scanner;

public class Practice7Wrath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nOfPeople = scanner.nextInt();
        int[] claws = new int[nOfPeople];
        for (int i = 0; i < nOfPeople; i++) {
            claws[i] = scanner.nextInt();
        }

        int killed = 0;
        int k = nOfPeople - 1;
        int j = nOfPeople - 2;
        while (j >= 0) {
            if (k == j) {
                j --;
            }

            if (claws[k] > 0 && j >= k - claws[k]) {
                killed++;
                j--;
            } else {
                k--;
            }
        }
        System.out.println(nOfPeople - killed);
    }
}
