
interface Notifier 
{ 
    void send(String message); 
} 
 
 
interface Urgent 
{ 
} 
 
class EmailSender implements Notifier, Urgent 
{ 
    public void send(String message) 
    { 
        System.out.println("Email: " + message); 
    } 
} 
 
class SMSSender implements Notifier 
{ 
    public void send(String message) 
    { 
        System.out.println("SMS: " + message); 
    } 
} 
 
public class Driver 
{ 
    public static void main(String[] args) 
    { 
     
        Notifier email = (message) -> 
        { 
            System.out.println("Email: " + message); 
        }; 
 
        Notifier sms = (message) -> 
        { 
            System.out.println("SMS: " + message); 
        }; 
 
        Notifier[] senders = 
        { 
            email, 
            sms 
        }; 
 
        String message = "Important notification"; 
 
        System.out.println("Broadcast:"); 
 
        for (Notifier sender : senders) 
        { 
            sender.send(message); 
        } 
 
         
        EmailSender urgentEmail = new EmailSender(); 
 
        System.out.println("\nUrgent Notification:"); 
 
        urgentEmail.send(message); 
        urgentEmail.send(message); 
 
        System.out.println("\n Dhairy Chauhan 25CE015"); 
    } 
} 