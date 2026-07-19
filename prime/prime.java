import java.util.Scanner;

public class prime {

    public static void main (String[] args){
        
        Scanner sc = new Scanner (System.in);
        int n ;
        System.out.println(" Enter the number you want ");
        n = sc.nextInt ();

        if (n <= 1) {
            System.out.println(" The number is not prime number ");
        } else {
            boolean isPrime = true;
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println("the prime number is " + n);
            } else {
                System.out.println(" The number is not prime number ");
            }
        }

    }
}