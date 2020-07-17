import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NuclearWaste {

    public static int[] prices;
    public static int[][] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));


        prices = Arrays.stream(rd.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = Integer.parseInt(rd.readLine());

        dp = new int[prices.length + 1][];

        int bestSum = Integer.MAX_VALUE;
        int temp = n;

        recur(temp, bestSum);


    }

    public static void recur(int temp, int bestSum){

        for (int i = dp.length - 1; i > 0; i--) {
            for (int j = dp[i].length - 1; j > 0 ; j--) {
                if (temp - i < 0) {
                    return;
                }

                int repeats = temp / i;
                dp[i][j] = prices[i - 1] * repeats;
                temp -= repeats;


            }


            temp -= (i + 1);

            recur(temp, bestSum);


        }
    }



}
