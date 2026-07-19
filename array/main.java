import java.util.Scanner;

public class main {
    

    public static void main (String[]args){

        Scanner sc = new Scanner (System.in);
        int []arr = new int[10];
        System.out.println(" Enter the numebr of elemments you want : ");

        for ( int i=0 ; i<10 ; i++){

            arr[i] = sc.nextInt();
        }

        for ( int i = 0 ; i < 10 ; i++){
            if (arr[i] % 4 == 0){
                arr[i] *= 5;
            }
        }
        
        for ( int i = 0 ; i< 10 ; i++ ){

            System.out.println(" the array " + arr[i]);
        }
    }
}
