import java.util.Scanner;

enum Coin
{
    ONE,TWO,FIVE,TEN
}

class practical
{
        public static void main(String[] args)
        {
            int price=20;
            int total=0;
         Scanner sc=new Scanner(System.in);
        
         
        while(price>total)
        {
             System.out.print("enter coin:");

         String input=sc.next().toUpperCase();

        Coin coin=Coin.valueOf(input);
         int value=switch(coin)
         {
            case ONE->1;
            case TWO->2;
            case FIVE->5;
            case TEN->10;
         };

         total+=value;
        
        
        }
         System.out.println(total);
        System.out.println(total-price);

        }
        
}