import java.util.ArrayList;
import java.util.List;

class Counter {
    int count;

    void increment() {
        count = count + 1;
    }

    void incrementSafe() {
        count = count + 1;
    }
}

public class main {
    static final int THREADS = 4;
    static final int TIMES = 100000;

    public static void main(String[] args) throws InterruptedException {
        Counter raceCounter = new Counter();
        Counter safeCounter = new Counter();

        run(raceCounter, false);
        run(safeCounter, true);

        int expected = THREADS * TIMES;
        System.out.println("Threads      : " + THREADS);
        System.out.println("Per thread   : " + TIMES);
        System.out.println("Expected     : " + expected);
        System.out.println("No sync      : " + raceCounter.count + " " + verdict(raceCounter.count == expected));
        System.out.println("With sync    : " + safeCounter.count + " " + verdict(safeCounter.count == expected));
    }

    static void run(Counter counter, boolean useSync) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREADS; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < TIMES; j++) {
                    if (useSync) {
                        counter.incrementSafe();
                    } else {
                        counter.increment();
                    }
                }
            });
            threads.add(t);
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }
    }

    static String verdict(boolean correct) {
        return correct ? "(correct)" : "(too low, updates were lost)";
    }
}
