import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class main {
    public static void main (String args[]){
        String email = "dkc074837@gmail.com";

        Pattern pattern = Pattern.compile("^[A-Za-z0-9,%+-]+@gmail\\.com$");
        Matcher matcher = pattern.matcher(email);

        if ( matcher.matches()){
            System.out.println(" valid email");
        }
        else{
            System.out.println("Invalid email");
        }

        String Email = "dkc074837@gmail.com";

        if ( Email.matches("^[A-Za-z0-9,%+-]+@gmail\\.com$")){
            System.out.println(" Valid email ");
        }
        else{
            System.out.println(" Invalid Email ");
        }

    }    
}
