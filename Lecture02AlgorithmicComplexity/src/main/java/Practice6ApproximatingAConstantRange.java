import java.util.Scanner;

public class Practice6ApproximatingAConstantRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nOfSample = scanner.nextInt();
        int[] samples = new int[nOfSample];
        for (int i = 0; i < nOfSample; i++) {
            samples[i] = scanner.nextInt();
        }

        int longest = 0;
        for (int i = 0; i < samples.length; i++) {
            int firstMinIndex = i;
            int lastMinIndex = i;
            int maxIndex = i;
            for (int j = i + 1; j < samples.length; j++) {
                int currentSample = samples[j];
                if (currentSample < samples[firstMinIndex]) {
                    firstMinIndex = j;
                } else if (currentSample == samples[firstMinIndex])  {
                    lastMinIndex = j;
                }

                if (currentSample > samples[maxIndex]) {
                    maxIndex = j;
                }

                int delta = Math.max(currentSample - samples[firstMinIndex], samples[maxIndex] - currentSample);
                if (delta > 1) {
                    longest = Math.max(longest, j - i);

                    if (firstMinIndex == i) {
                        i = lastMinIndex;
                    } else if (firstMinIndex == j) {
                        i = maxIndex;
                    } else {
                        i = firstMinIndex;
                    }
                    break;
                }
                if (j == samples.length - 1) {
                    longest = Math.max(longest, j - i + 1);
                    i = samples.length;
                    break;
                }
            }
        }

        System.out.println(longest);
    }
}
