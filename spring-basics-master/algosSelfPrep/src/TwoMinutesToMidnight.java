import java.util.Scanner;

public class TwoMinutesToMidnight {

    public static long calculated[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int k = Integer.parseInt(sc.nextLine());
        calculated = new long[n + 1][k + 1];
        long binomm = binom(n, k);

        System.out.println(binomm);
    }

    private static long binom(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        }

        if (calculated[n][k] != 0){
            return calculated[n][k];
        }

        return calculated[n][k] = binom(n - 1, k - 1) + binom(n - 1, k);
    }
}
