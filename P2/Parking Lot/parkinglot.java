import java.util.Scanner; 
 
class parkinglot 
{ 
    private int twowheelers = 0; 
    private int fourwheelers = 0; 
    private final int twocap = 30; 
    private final int fourcap = 30; 
    private static int revenue = 0; 
 
    void park(String type) 
    { 
        if(type.equals("two")) 
        { 
            if(twowheelers < twocap) 
            { 
                twowheelers++; 
            } 
            else 
            { 
                System.out.println("Full"); 
            } 
        } 
 
        if(type.equals("four")) 
        { 
            if(fourwheelers < fourcap) 
            { 
                fourwheelers++; 
            } 
            else 
            { 
                System.out.println("Full"); 
            } 
        } 
    } 
 
    void leave(String type) 
    { 
        if(type.equals("-")) 
        { 
            return; 
        } 
 
        if(type.equals("two")) 
        { 
            if(twowheelers > 0) 
            { 
                twowheelers--; 
            } 
            else 
            { 
                System.out.println("No two wheeler available"); 
            } 
        } 
 
        if(type.equals("four")) 
        { 
            if(fourwheelers > 0) 
            { 
                fourwheelers--; 
            } 
            else 
            { 
                System.out.println("No four wheeler available"); 
            } 
        } 
    } 
 
    void returnvalue() 
    { 
        System.out.println(20 * twowheelers + 40 * fourwheelers); 
    } 
 
    public static void main(String[] args) 
    { 
        parkinglot p = new parkinglot(); 
 
        Scanner sc = new Scanner(System.in); 
 
        for(int i = 0; i < 5; i++) 
        { 
            System.out.print("enter type for parking: "); 
            String input = sc.next(); 
            p.park(input); 
        } 
 
        for(int i = 0; i < 5; i++) 
        { 
            System.out.print("enter type for leave: "); 
            String input = sc.next(); 
            p.leave(input); 
        } 
 
        p.returnvalue(); 
 
        System.out.print("Dhairy Chauhan 25CE015");
    } 
} 