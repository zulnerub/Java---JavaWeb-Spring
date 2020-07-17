import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BlackMesa {

    public static  boolean[] visited;
    public static int[][] graph;
    public static Deque<Integer> queue;
    public static Deque<Integer> path;
    public static Deque<Integer> excluded;
    public static int target;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(rd.readLine());
        int m = Integer.parseInt(rd.readLine());


        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        while (m-- > 0){
            int[] connection = Arrays.stream(rd.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            graph[connection[0]][connection[1]] = 1;
        }

        int start = Integer.parseInt(rd.readLine().split("\\s+")[0]);
        target = Integer.parseInt(rd.readLine());

        path = new ArrayDeque<>();
        excluded = new ArrayDeque<>();

        queue = new ArrayDeque<>();

        visited[start] = true;
        if (start != 0){
            bfs(start);
        }


        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]){
                excluded.offer(i);
            }
        }


        while (!path.isEmpty()){
            System.out.print(path.poll() + " ");
        }

        if (!excluded.isEmpty()){
            System.out.println();
            while (!excluded.isEmpty()){
                System.out.print(excluded.poll() + " ");
            }
        }
    }

    private static void bfs(int start) {
        queue.offer(start);
        while (!queue.isEmpty()){
            int node = queue.poll();

            path.offer(node);
            if (node != target){
                for (int i = 1; i < graph[node].length; i++) {
                    if (graph[node][i] != 0 && !visited[i]){
                        visited[i] = true;
                        queue.offer(i);
                        if (i == target){
                            break;
                        }

                    }
                }
            }else {
                break;
            }

        }
    }
}
