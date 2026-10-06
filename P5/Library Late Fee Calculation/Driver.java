abstract class Media 
{ 
    String title; 
    int lateDays; 
 
    Media(String title, int lateDays) 
    { 
        this.title = title; 
        this.lateDays = lateDays; 
    } 
 
    abstract double calculateLateFee(); 
} 
 
class Book extends Media 
{ 
    Book(String title, int lateDays) 
    { 
        super(title, lateDays); 
    } 
 
    double calculateLateFee() 
    { 
        return lateDays * 2; 
    } 
} 
 
class DVD extends Media 
{ 
    DVD(String title, int lateDays) 
    { 
        super(title, lateDays); 
    } 
 
    double calculateLateFee() 
    { 
        return lateDays * 5; 
    } 
} 
 
class Magazine extends Media 
{ 
    Magazine(String title, int lateDays) 
    { 
        super(title, lateDays); 
    } 
 
    double calculateLateFee() 
    { 
        return lateDays * 1; 
    } 
} 
 
public class Driver 
{ 
    public static void main(String[] args) 
    { 
        Media[] media = { 
            new Book("Java Book", 3), 
            new DVD("Avengers DVD", 2), 
            new Magazine("Tech Magazine", 4) 
        }; 
 
        double total = 0; 
 
        for (Media m : media) 
        { 
            double fee = m.calculateLateFee(); 
 
            System.out.println(m.title + " = Rs." + fee); 
 
            total = total + fee; 
        } 
 
        System.out.println("Total Late Fee = Rs." + total); 
        System.out.println("Dhairy Chauhan 25CE015");
 
    } 
} 