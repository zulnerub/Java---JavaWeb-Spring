import java.util.Arrays;
import java.util.Scanner;

public class HiddenValues {
    public static int[] input;
    public static int maxSum = Integer.MIN_VALUE;
    public static int[] bestCoords = new int[2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        input = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();


        for (int i = 0; i < input.length; i++) {
            int currentSum = 0;
            if (input[i] > maxSum) {
                bestCoords[0] = i;
                bestCoords[1] = i;
                maxSum = input[i];
            }
            currentSum += input[i];

            for (int j = i + 1; j < input.length; j++) {
                currentSum += input[j];
                if (currentSum > maxSum) {
                    bestCoords[0] = i;
                    bestCoords[1] = j;
                    maxSum = currentSum;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(maxSum).append(System.lineSeparator());
        for (int i = bestCoords[0]; i <= bestCoords[1] ; i++) {
            sb.append(input[i]).append(" ");
        }

        System.out.println(sb.toString().trim());
    }


}
