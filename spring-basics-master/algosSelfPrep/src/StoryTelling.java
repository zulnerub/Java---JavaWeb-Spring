import java.util.*;
import java.util.stream.Collectors;

public class StoryTelling {
    public static LinkedHashMap<String, List<String>> graph = new LinkedHashMap<>();
    public static Set<String> visited = new HashSet<>();
    public static List<String> orderOfInput = new ArrayList<>();
    public static List<String> orderedNodes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        while (!input.equals("End")) {
            String[] values = input.split("\\s+->\\s+|\\s+->");
            List<String> edges = new ArrayList<>();

            if (values.length > 1){
                edges = Arrays.stream(values[1].split("\\s+")).collect(Collectors.toList());
            }

            graph.put(values[0], edges);
            orderOfInput.add(values[0]);
            input = sc.nextLine();
        }

        graph.forEach((key, value) -> topSort(key));

        Collections.reverse(orderedNodes);
        System.out.println(String.join(" ", orderedNodes));

    }

    private static void topSort(String node) {
        if (!visited.contains(node)) {
            visited.add(node);
            for (String child : graph.get(node)) {
                topSort(child);
            }
            orderedNodes.add(node);
        }
    }

}
