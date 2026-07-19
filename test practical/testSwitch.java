import java.util.Scanner;
enum Day{
    MONDAY,
    TUESDAY,
    WEDNESDAY
}

public class testSwitch{

    public static void main (String [] args){
        Scanner sc= new Scanner (System.in);
        System.out.println(" Enter the day : ");
        String s = sc.next().toUpperCase();
        Day day = Day.valueOf(s);
        String result = switch (day) {
                case MONDAY -> " Today is Monday";
                case TUESDAY -> " today is tuesday";
                case WEDNESDAY -> " today is wednesday";

        };
        System.out.println(result);
        sc.close();

    }
}