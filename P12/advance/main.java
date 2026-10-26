import java.util.*;

public class main{
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();

        scores.put("Dhairy", 95);
        scores.put("Aman", 88);
        scores.put("Priya", 95);
        scores.put("Jay", 76);
        scores.put("Neha", 88);

        int n = 3;

        List<Map.Entry<String, Integer>> players =
                new ArrayList<>(scores.entrySet());

        players.sort((a, b) -> {
            int result = b.getValue().compareTo(a.getValue());
            if (result == 0) {
                return a.getKey().compareTo(b.getKey());
            }
            return result;
        });

        System.out.println("Top " + n + " players:");

        for (int i = 0; i < Math.min(n, players.size()); i++) {
            Map.Entry<String, Integer> p = players.get(i);
            System.out.println(p.getKey() + " - " + p.getValue());
        }

        System.out.println("Dhairy Chauhan 25ce015");
    }
}
