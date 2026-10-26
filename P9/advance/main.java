import java.util.concurrent.atomic.AtomicLong;

public class main {
    private static final int SIZE = 10_000_000;
    private static final int THREADS = 4;
    private static final int[] ARRAY = new int[SIZE];

    static {
        for (int i = 0; i < SIZE; i++) {
            ARRAY[i] = 1;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Expected total: " + SIZE);
        System.out.println("-----------------------------------");
        
        runWrongWay();
        runFixOne();
        runFixTwo();
    }

    private static void runWrongWay() throws InterruptedException {
        WrongAdder adder = new WrongAdder();
        Thread[] threads = new Thread[THREADS];
        int chunkSize = SIZE / THREADS;

        long start = System.nanoTime();
        for (int i = 0; i < THREADS; i++) {
            int startIdx = i * chunkSize;
            int endIdx = (i == THREADS - 1) ? SIZE : startIdx + chunkSize;
            threads[i] = new Thread(() -> adder.add(startIdx, endIdx));
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }
        long end = System.nanoTime();

        System.out.println("Wrong Approach Total: " + adder.total);
        System.out.println("Wrong Approach Time: " + (end - start) / 1_000_000.0 + " ms");
        System.out.println("-----------------------------------");
    }

    private static void runFixOne() throws InterruptedException {
        SyncAdder adder = new SyncAdder();
        Thread[] threads = new Thread[THREADS];
        int chunkSize = SIZE / THREADS;

        long start = System.nanoTime();
        for (int i = 0; i < THREADS; i++) {
            int startIdx = i * chunkSize;
            int endIdx = (i == THREADS - 1) ? SIZE : startIdx + chunkSize;
            threads[i] = new Thread(() -> adder.add(startIdx, endIdx));
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }
        long end = System.nanoTime();

        System.out.println("Fix 1 (Synchronized) Total: " + adder.total);
        System.out.println("Fix 1 (Synchronized) Time: " + (end - start) / 1_000_000.0 + " ms");
        System.out.println("-----------------------------------");
    }

    private static void runFixTwo() throws InterruptedException {
        AtomicAdder adder = new AtomicAdder();
        Thread[] threads = new Thread[THREADS];
        int chunkSize = SIZE / THREADS;

        long start = System.nanoTime();
        for (int i = 0; i < THREADS; i++) {
            int startIdx = i * chunkSize;
            int endIdx = (i == THREADS - 1) ? SIZE : startIdx + chunkSize;
            threads[i] = new Thread(() -> adder.add(startIdx, endIdx));
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }
        long end = System.nanoTime();

        System.out.println("Fix 2 (AtomicLong) Total: " + adder.total.get());
        System.out.println("Fix 2 (AtomicLong) Time: " + (end - start) / 1_000_000.0 + " ms");
        System.out.println("-----------------------------------");
    }

    static class WrongAdder {
        long total = 0;

        public void add(int start, int end) {
            for (int i = start; i < end; i++) {
                total += ARRAY[i];
            }
        }
    }

    static class SyncAdder {
        long total = 0;

        public synchronized void add(int start, int end) {
            long localSum = 0;
            for (int i = start; i < end; i++) {
                localSum += ARRAY[i];
            }
            synchronized (this) {
                total += localSum;
            }
        }
    }

    static class AtomicAdder {
        AtomicLong total = new AtomicLong(0);

        public void add(int start, int end) {
            long localSum = 0;
            for (int i = start; i < end; i++) {
                localSum += ARRAY[i];
            }
            total.addAndGet(localSum);
        }
    }
}
