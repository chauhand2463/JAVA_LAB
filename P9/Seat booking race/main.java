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

public static void main(String[] args) throws InterruptedException {
        Seat seat = new Seat();
        BookingThread[] threads = new BookingThread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new BookingThread(seat);
            threads[i].start();
        }
        for (int i = 0; i < 10; i++) {
            threads[i].join();
        }

        System.out.println("Seats left: " + seat.seatsLeft);

        SyncSeat syncSeat = new SyncSeat();
        SyncBookingThread[] syncThreads = new SyncBookingThread[10];
        for (int i = 0; i < 10; i++) {
            syncThreads[i] = new SyncBookingThread(syncSeat);
            syncThreads[i].start();
        }
        for (int i = 0; i < 10; i++) {
            syncThreads[i].join();
        }

        System.out.println("Seats left after synchronized booking: " + syncSeat.seatsLeft);
    }