import java.util.Scanner;

class Thermostat {
    private String location;
    private int temperature;
    private static final int MIN = 16;
    private static final int MAX = 30;
    private static int activeCount = 0;

    Thermostat(String location, int startTemp) {
        this.location = location;
        if (startTemp >= MIN && startTemp <= MAX) {
            this.temperature = startTemp;
        } else {
            this.temperature = 22;
        }
        activeCount++; 
    }

    Thermostat(String location) {
        this(location, 22);
    }

    void raise() {
        if (temperature < MAX) {
            temperature++;
        } else {
            System.out.println("Already at max with 30");
        }
    }

    void lower() {
        if (temperature > MIN) {
            temperature--;
        } else {
            System.out.println("Already at min with 16");
        }
    }

    int getTemperature() {
        return temperature;
    }

    static int getActiveCount() {
        return activeCount;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Thermostat t1 = new Thermostat(null, 0);

        for (int i = 0; i <= 10; i++) {
            t1.raise();
            System.out.println("temperature: " + t1.getTemperature());
            System.out.println("");
            if (t1.getTemperature() == 30) { 
                break;
            }
        }

        for (int i = 0; i <= 20; i++) {
            t1.lower();
            System.out.println("temperature: " + t1.getTemperature());
            System.out.println("");
            if (t1.getTemperature() == 16) {
                break;
            }
        }

        System.out.println("All the active counts: " + Thermostat.getActiveCount());
        sc.close();
    }
}
