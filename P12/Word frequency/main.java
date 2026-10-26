import java.util.*;

public class main{
    public static void main(String[] args) {
        String text = "java is easy and java is useful and java is popular";
        String[] words = text.toLowerCase().split("\\W+");

        HashMap<String, Integer> freq = new HashMap<>();

        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(freq.entrySet());

        list.sort((a, b) -> {
            int result = b.getValue().compareTo(a.getValue());
            if (result == 0) {
                return a.getKey().compareTo(b.getKey());
            }
            return result;
        });

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("Dhairy Chauhan 25CE015");
    }
}
