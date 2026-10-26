import java.util.*;

public class main{
    public static void main(String[] args) {
        String[] visitors = {
            "Dhairy", "aman", "priya", "rahil",
            "jay", "aman", "neha", "priya"
        };

        HashSet<String> unique = new HashSet<>();
        LinkedHashSet<String> ordered = new LinkedHashSet<>();

        for (String name : visitors) {
            unique.add(name);
            ordered.add(name);
        }

        System.out.println("Unique visitors: " + unique.size());
        System.out.println("First three visitors:");

        int count = 0;
        for (String name : ordered) {
            if (count == 3) {
                break;
            }
            System.out.println(name);
            count++;
        }

        System.out.println("Dhairy Chauhan 25CE015");
    }
}
