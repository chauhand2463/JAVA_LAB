import java.util.concurrent.CountDownLatch;

class Account {
    int accountNumber;
    int balance;

    Account(int accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}

public class main{
    static void unsafeTransfer(Account from, Account to,
                              CountDownLatch ready) {
        synchronized (from) {
            ready.countDown();

            try {
                ready.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }

            synchronized (to) {
                from.balance -= 100;
                to.balance += 100;
            }
        }
    }

    static void safeTransfer(Account from, Account to) {
        Account first = from.accountNumber < to.accountNumber
                ? from : to;
        Account second = from.accountNumber < to.accountNumber
                ? to : from;

        synchronized (first) {
            synchronized (second) {
                from.balance -= 100;
                to.balance += 100;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Account a = new Account(1, 1000);
        Account b = new Account(2, 1000);
        CountDownLatch ready = new CountDownLatch(2);

        Thread t1 = new Thread(() -> unsafeTransfer(a, b, ready));
        Thread t2 = new Thread(() -> unsafeTransfer(b, a, ready));

        t1.setDaemon(true);
        t2.setDaemon(true);

        t1.start();
        t2.start();

        t1.join(500);
        t2.join(500);

        if (t1.isAlive() || t2.isAlive()) {
            System.out.println("Deadlock detected in unsafe transfer");
        } else {
            System.out.println("Unsafe transfers completed");
        }

        Account c = new Account(1, 1000);
        Account d = new Account(2, 1000);

        Thread t3 = new Thread(() -> safeTransfer(c, d));
        Thread t4 = new Thread(() -> safeTransfer(d, c));

        t3.start();
        t4.start();

        t3.join();
        t4.join();

        System.out.println("Fixed transfers completed");
        System.out.println("Account 1 balance: " + c.balance);
        System.out.println("Account 2 balance: " + d.balance);
        System.out.println("Dhairy Chauhan 25CE015");
    }
}
