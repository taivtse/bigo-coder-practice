import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practice2GeorgeAndRound {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nOfRequired = scanner.nextInt();
        int nOfPrepared = scanner.nextInt();

        List<Integer> requiredArr = new ArrayList<>(nOfRequired);
        for (int i = 0; i < nOfRequired; i++) {
            requiredArr.add(scanner.nextInt());
        }

        List<Integer> preparedArr = new ArrayList<>(nOfPrepared);
        for (int i = 0; i < nOfPrepared; i++) {
            preparedArr.add(scanner.nextInt());
        }

        int missingCount = 0;
        int nextCheckPoint = 0;
        for (Integer required : requiredArr) {
            boolean isExists = false;
            for (int i = nextCheckPoint; i < preparedArr.size(); i++) {
                Integer prepared = preparedArr.get(i);
                if (prepared >= required) {
                    nextCheckPoint = i + 1;
                    isExists = true;
                    break;
                }
            }

            if (!isExists) {
                missingCount++;
            }
        }

        System.out.println(missingCount);
    }
}
