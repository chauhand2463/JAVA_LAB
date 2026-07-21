import java.util.Scanner;

enum move (
    ROCK, PAPER, SCISSORS, LIZARD, SPOCK,
)

public record winner (move a , move b) {};

public class main{

    public static void main (String [] args){

        Scanner sc = new sc (System.in);

        String input = sc.next();

        int move = switch (input.toUpperCase()){
            case "ROCK" -> {}
        }


        sc.close();
    }
}