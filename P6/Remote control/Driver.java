
interface Switchable 
{ 
    void on(); 
    void off(); 
 
    default void toggle() 
    { 
        on(); 
    } 
} 
 
class Fan implements Switchable 
{ 
    private boolean status = false; 
 
    public void on() 
    { 
        status = true; 
        System.out.println("Fan is ON"); 
    } 
 
    public void off() 
    { 
        status = false; 
        System.out.println("Fan is OFF"); 
    } 
} 
 
class Light implements Switchable 
{ 
    private boolean status = false; 
 
    public void on() 
    { 
        status = true; 
        System.out.println("Light is ON"); 
    } 
 
    public void off() 
    { 
        status = false; 
        System.out.println("Light is OFF"); 
    } 
} 
 
 
interface SwitchRule 
{ 
    boolean maySwitchOn(Switchable device, int hour); 
} 
 
public class Driver 
{ 
    public static void main(String[] args) 
    { 
       
        Switchable[] devices = 
        { 
            new Fan(), 
            new Light() 
        }; 
 
        System.out.println("Toggling Devices:"); 
 
        for (Switchable device : devices) 
        { 
            device.toggle(); 
        } 
 
 
        SwitchRule rule1 = new SwitchRule() 
        { 
            public boolean maySwitchOn(Switchable device, int hour) 
            { 
                return hour >= 6 && hour <= 22; 
            } 
        }; 
 
        SwitchRule rule2 = (device, hour) -> 
        { 
            return hour >= 8 && hour <= 20; 
        }; 
 
        System.out.println("\nAnonymous Class:"); 
 
        System.out.println("At 10:00: " + 
                rule1.maySwitchOn(devices[0], 10)); 
 
        System.out.println("At 23:00: " + 
                rule1.maySwitchOn(devices[0], 23)); 
 
        System.out.println("\nLambda:"); 
 
        System.out.println("At 10:00: " + 
                rule2.maySwitchOn(devices[1], 10)); 
 
        System.out.println("At 23:00: " + 
                rule2.maySwitchOn(devices[1], 23)); 
 
        System.out.println("\n Dhairy Chauhan 25CE015");
    } 
} 