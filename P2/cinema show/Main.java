class CinemaShow {
    String title;
    private int SeatsAvailable;
    private final int capacity;
    private static int totalBooked = 0;

    CinemaShow(String title, int capacity) {
        this.capacity = capacity;
        this.title = title;
        this.SeatsAvailable = capacity;
    }

    CinemaShow(String title) {
        this(title, 100);
    }

    int book(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= SeatsAvailable) {
            SeatsAvailable = SeatsAvailable - n;
            totalBooked = totalBooked + n;
            return 1;
        } else {
            return 0;
        }
    }

    int cancel(int n) {
        if (n <= 0) {
            return SeatsAvailable;
        }
        if (n <= capacity - SeatsAvailable) {
            SeatsAvailable = SeatsAvailable + n;
            totalBooked = totalBooked - n;
            return SeatsAvailable;
        } else {
            return SeatsAvailable;
        }
    }

    int gsa() {
        return SeatsAvailable;
    }

    static int gtb() {
        return totalBooked;
    }
}

public class Main {
    public static void main(String[] args) {
        CinemaShow cs = new CinemaShow("spiderman : brand new day", 100);
        cs.book(76);
        System.out.println("seats:" + cs.title + " " + cs.gsa());
        System.out.println("total seat: " + CinemaShow.gtb());

        cs.cancel(25);
        System.out.println("total seats available" + cs.title + ""+cs.gsa());
    }
}
