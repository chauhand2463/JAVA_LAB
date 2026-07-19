package VendingMachine;

import java.util.Scanner;

enum Rupee {
    ONE,
    TWO,
    FIVE,
    TEN
}

public class main {
    public static main(String[] args) {~
        Scanner sc = new Scanner(System.in);
        String result = null;
        String s;

        while (result == null) {
            System.out.println("Enter the rupee you want (one, two, five, ten):");
            s = sc.nextLine().trim();

            if (s.isEmpty()) {
                System.out.println("No amount entered. Please enter a valid rupee.");
                continue;
            }

            switch (s.toUpperCase()) {
                case "ONE" -> result = "1";
                case "TWO" -> result = "2";
                case "FIVE" -> result = "5";
                case "TEN" -> result = "10";
                default -> {
                    System.out.println("Invalid rupee: " + s + ". Returning money.");
                    result = null;
                }
            }
        }

        System.out.println("Selected rupee: " + result);
        sc.close();
    }
}
