import java.util.Arrays;
import java.util.Scanner;

public class NuclearWaste {
    private static int flaskCount;
    private static int[] costs;
    private static long[] minimalCosts;
    private static int[] previousFlaskCount;

    public static void main(String[] args) {
        readInput();

        initialize();

        calculatePrices();

        printResult();
    }

    private static void readInput() {
        Scanner scanner = new Scanner(System.in);
        int[] inputCosts = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        costs = new int[inputCosts.length + 1];
        costs[0] = 0;
        System.arraycopy(inputCosts, 0, costs, 1, inputCosts.length);
        flaskCount = Integer.parseInt(scanner.nextLine());
    }

    private static void initialize() {
        minimalCosts = new long[flaskCount + 1];
        for (int i = 0; i <= flaskCount; i++) {
            if (i >= costs.length) {
                minimalCosts[i] = minimalCosts[i - 1] + minimalCosts[1];
            } else {
                minimalCosts[i] = costs[i];
            }
        }
        previousFlaskCount = new int[flaskCount + 1];
    }

    private static void calculatePrices() {
        for (int i = 1; i <= flaskCount; i++) {
            for (int j = 1; j <= i; j++) {
                long currentMinPrice;
                if (j >= costs.length) {
                    currentMinPrice = minimalCosts[j] + minimalCosts[i - j];
                } else {
                    currentMinPrice = Math.min(minimalCosts[i], costs[j] + minimalCosts[i - j]);
                }
                if (currentMinPrice < minimalCosts[i]) {
                    minimalCosts[i] = currentMinPrice;
                    previousFlaskCount[i] = j;
                }
            }
        }
    }

    private static void printResult() {
        StringBuilder output = new StringBuilder();
        output.append("Cost: ").append(minimalCosts[flaskCount]).append(System.lineSeparator());
        int size = flaskCount;
        while (previousFlaskCount[size] > 0) {
            output.append(previousFlaskCount[size]).append(" => ").append(minimalCosts[previousFlaskCount[size]])
                    .append(System.lineSeparator());
            size = size - previousFlaskCount[size];
        }
        output.append(size).append(" => ").append(minimalCosts[size]);
        System.out.println(output.toString().trim());
    }
}