import java.util.regex.Matcher; 
import java.util.regex.Pattern; 
import java.util.Scanner;  

class pass {      
    static int strength(String pw) {          
        int l = pw.length();         
        int count = 0;     
        
        if (l >= 8) {             
            count++;         
        }         
        if (pw.matches(".*[A-Z].*")) {             
            count++;         
        }         
        if (pw.matches(".*[0-9].*")) {             
            count++;         
        }         
        if (pw.matches(".*[^a-zA-Z0-9].*")) {             
            count++;         
        }         
        
        System.out.println(count);     

        if (count == 1){
            System.out.println("Weak");
        }
        else if ( count == 2 || count == 3){
            System.out.println("Medium");
        }
        else if(count == 4){
            System.out.println("Strong");
        }
        else{
            System.out.println("Retry");
        }
        return count;
    } 
}  

public class main {     
    public static void main(String args[]) {         
        Scanner sc = new Scanner(System.in);          
        
        System.out.println("Enter your password: ");         
        String password = sc.next();          
        
        pass.strength(password);          
        sc.close();     
    } 
}
