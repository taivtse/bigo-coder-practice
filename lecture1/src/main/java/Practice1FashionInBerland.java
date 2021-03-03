import java.util.Scanner;

public class Practice1FashionInBerland {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nOfButtons = scanner.nextInt();

        boolean isFastened = false;
        boolean isValidButton = false;
        for (int i = 0; i < nOfButtons; i++) {
            String button = scanner.next();
            if ("1".equals(button)) {
                isFastened = true;
                if (nOfButtons == 1) {
                    isValidButton = true;
                    break;
                }
            } else {
                if (isValidButton) {
                    isValidButton = false;
                    break;
                }

                isValidButton = true;
            }
        }

        isFastened = isFastened && isValidButton;
        System.out.println(isFastened ? "YES" : "NO");
    }
}
