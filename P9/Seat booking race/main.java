class Seat {
    int seatsLeft = 5;

boolean book() throws InterruptedException {
        if (seatsLeft > 0) {
            Thread.sleep(2);
            seatsLeft = seatsLeft - 1;
            return true;
        }
        return false;
    }
}

class BookingThread extends Thread {
    Seat seat;
    boolean got;

    BookingThread(Seat seat) {
        this.seat = seat;
    }

    public void run() {
        try {
            got = seat.book();
        } catch (InterruptedException e) {
            got = false;
        }
        if (got) {
            System.out.println(getName() + " booked a seat");
        } else {
            System.out.println(getName() + " failed to book");
        }
    }
}

class SyncSeat {
    int seatsLeft = 5;

    synchronized boolean book() throws InterruptedException {
        if (seatsLeft > 0) {
            Thread.sleep(2);
            seatsLeft = seatsLeft - 1;
            return true;
        }
        return false;
    }
}

class SyncBookingThread extends Thread {
    SyncSeat seat;
    boolean got;

    SyncBookingThread(SyncSeat seat) {
        this.seat = seat;
    }

    public void run() {
        try {
            got = seat.book();
        } catch (InterruptedException e) {
            got = false;
        }
        if (got) {
            System.out.println(getName() + " booked a seat");
        } else {
            System.out.println(getName() + " failed to book");
        }
    }
}

public class main {
    public static void main(String[] args) throws InterruptedException {
        Seat seat = new Seat();
        BookingThread[] t = new BookingThread[10];
        for (int i = 0; i < t.length; i++) {
            t[i] = new BookingThread(seat);
            t[i].setName("User-" + i);
        }
        for (int i = 0; i < t.length; i++) {
            t[i].start();
        }
        for (int i = 0; i < t.length; i++) {
            t[i].join();
        }
        int booked = 0;
        for (int i = 0; i < t.length; i++) {
            if (t[i].got) {
                booked++;
            }
        }
        System.out.println("Without synchronization -> booked = " + booked + " , seatsLeft = " + seat.seatsLeft);

        SyncSeat sseat = new SyncSeat();
        SyncBookingThread[] st = new SyncBookingThread[10];
        for (int i = 0; i < st.length; i++) {
            st[i] = new SyncBookingThread(sseat);
            st[i].setName("User-" + i);
        }
        for (int i = 0; i < st.length; i++) {
            st[i].start();
        }
        for (int i = 0; i < st.length; i++) {
            st[i].join();
        }
        int sbooked = 0;
        for (int i = 0; i < st.length; i++) {
            if (st[i].got) {
                sbooked++;
            }
        }
        System.out.println("With synchronization  -> booked = " + sbooked + " , seatsLeft = " + sseat.seatsLeft);
    }
}