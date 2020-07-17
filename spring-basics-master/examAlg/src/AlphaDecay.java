import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class AlphaDecay {
    public static boolean[] used;
    public static int[] result;
    public static int[] elements;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        elements = Arrays.stream(rd.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int n = Integer.parseInt(rd.readLine());
        result = new int[n];
        used = new boolean[elements.length];
        variations(0);
    }

    public static void variations(int index) {
        if (index >= result.length) {
            for (int value : result) {
                System.out.print(value + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < elements.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    result[index] = elements[i];
                    variations(index + 1);
                    used[i] = false;
                }
            }
        }
    }
}
