import java.util.Scanner;

enum VehicleType {
    BIKE,
    CAR,
    TRUCK
}

record Vehicle(int number, VehicleType type) {}

class Practical {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int toll = 0, b = 0, c = 0, t = 0;

        System.out.print("Enter vehicle type : ");
        String input = sc.next().toUpperCase();

        while (!input.equals("DONE")) {

            VehicleType type = VehicleType.valueOf(input);

            System.out.print("Enter vehicle number: ");
            int number = sc.nextInt();

            Vehicle v = new Vehicle(number, type);

            switch (v.type()) {
                case BIKE -> {
                    toll += 20;
                    b++;
                }
                case CAR -> {
                    toll += 50;
                    c++;
                }
                case TRUCK -> {
                    toll += 150;
                    t++;
                }
            }

            System.out.print("Enter vehicle type: ");
            input = sc.next().toUpperCase();
        }

        System.out.println("Total Toll = " + toll);
        System.out.print("Most frequent:");
        if(b>c)
        {
            if(b>t)
            {
                System.out.print("BIKE");
            }
            else
            {
                System.out.print("CAR");
            }
        }
        else{
            if(c>t)
            {
                System.out.print("CAR");
            }
            else
            {
                System.out.print("TRUCK");
            }
        }

        sc.close();
    }
}