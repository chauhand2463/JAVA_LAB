import java.util.Scanner;

enum Move {
    ROCK, PAPER, SCISSORS, LIZARD, SPOCK
}

record Winner(Move me, Move computer) {};

public class Main {

    public static void main(String[] args) {

        int k = 0;
        int j = 0;
        int Computer = 0;
        int Me = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your move:");
        String me = sc.next().toUpperCase();

        System.out.println("Enter computer move:");
        String computer = sc.next().toUpperCase();

        Move me1 = Move.valueOf(me);
        Move computer1 = Move.valueOf(computer);

        Winner w = new Winner(me1, computer1);

       while (k != 5) {

            k++;

            j = switch (w.me()) {

                case ROCK ->
                    (w.computer() == Move.SCISSORS ||
                            w.computer() == Move.LIZARD) ? 1 : -1;

                case PAPER ->
                    (w.computer() == Move.ROCK ||
                            w.computer() == Move.SPOCK) ? 1 : -1;

                case SCISSORS ->
                    (w.computer() == Move.PAPER ||
                            w.computer() == Move.LIZARD) ? 1 : -1;

                case LIZARD ->
                    (w.computer() == Move.PAPER ||
                            w.computer() == Move.SPOCK) ? 1 : -1;

                case SPOCK ->
                    (w.computer() == Move.ROCK ||
                            w.computer() == Move.SCISSORS) ? 1 : -1;
            };

            if (j == (-1)) {
                Computer++;
                System.out.println("me move:" + Computer);
                System.out.println("computer move:" + Me);
                System.out.println("computer win");
            }

            if (j == 1) {
                Me++;
                System.out.println("me move:" + Computer);
                System.out.println("computer move:" + Me);
                System.out.println("me win");
            }

            if (Me == Computer) {
                System.out.println(" Tie ");
            }

            System.out.println("Enter your move:");
            me = sc.next().toUpperCase();

            System.out.println("Enter computer move:");
            computer = sc.next().toUpperCase();

            me1 = Move.valueOf(me);
            computer1 = Move.valueOf(computer);

            w = new Winner(me1, computer1);

            if (Computer > Me) {
                System.out.println("computer win " + Computer + " - " + Me);
            }

            if (Me > Computer) {
                System.out.println("you win " + Me + " - " + Computer);
            }
        }

        sc.close();
    }
}

