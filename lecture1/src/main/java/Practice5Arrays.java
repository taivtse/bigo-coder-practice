import java.util.Scanner;

public class Practice5Arrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nOfA = scanner.nextInt();
        int nOfB = scanner.nextInt();
        int k = scanner.nextInt();
        int m = scanner.nextInt();

        int[] arrayA = new int[nOfA];
        for (int i = 0; i < nOfA; i++) {
            arrayA[i] = scanner.nextInt();
        }

        int[] arrayB = new int[nOfB];
        for (int i = 0; i < nOfB; i++) {
            arrayB[i] = scanner.nextInt();
        }

        boolean isValid = arrayA[k - 1] < arrayB[nOfB - m];
        System.out.println(isValid ? "YES" : "NO");
    }
}
