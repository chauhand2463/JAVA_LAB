import java.util.concurrent.*;

 

public class main {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService pool = Executors.newFixedThreadPool(3);

 

        for (int i = 1; i <= 10; i++) {

            final int id = i;

            pool.execute(() -> {

                System.out.println("Task " + id + " running on " +

                                   Thread.currentThread().getName());

                try {

                    Thread.sleep(200);

                } catch (InterruptedException e) {

                    Thread.currentThread().interrupt();

                }

            });

        }

 

        pool.shutdown();

        if (!pool.awaitTermination(5, TimeUnit.SECONDS)) {

            pool.shutdownNow();

        }

 

        System.out.println("All tasks completed");
        System.out.println("Dhairy Chauhan 25CE015");

    }

}
