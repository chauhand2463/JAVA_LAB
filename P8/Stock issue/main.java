import java.util.Scanner;

class Warehouse {
    public String item;
    public int stock;

    public Warehouse(String item, int stock) {
        this.item = item;
        this.stock = stock;
    }

    public void issue(String item, int qty) throws InvalidQuantityException, OutOfStockException {
        if (qty <= 0) {
            throw new InvalidQuantityException("Quantity must be greater than zero. Requested: " + qty);
        }
        if (qty > stock) {
            throw new OutOfStockException("not enoght qty", qty - stock);
        }
        this.stock = this.stock - qty;
    }
}

class OutOfStockException extends Exception {
    public int shortfall;

    public OutOfStockException(String message, int shortfall) {
        super(message);
        this.shortfall = shortfall;
    }

    public int getShortfall() {
        return shortfall;
    }
}

class InvalidQuantityException extends Exception {
    public InvalidQuantityException(String message) {
        super(message);
    }
}

record Request(String item, int qty) {}

public class main {
    public static void main(String args[]) {
        Warehouse w = new Warehouse("Gada electronics", 2500000);
        Request[] requests = {
            new Request("TV", 5),
            new Request("mobile", 0),
            new Request("", 15),
            new Request("XBOX", 26),
            new Request("CPU", 3),
            new Request("FlipperZero", 2)
        };

        for (Request req : requests) {
            try {
                w.issue(req.item(), req.qty());
            } catch (InvalidQuantityException e) {
                System.err.println("Failure: " + e.getMessage());
            } catch (OutOfStockException e) {
                System.err.println("Failure: " + e.getMessage() + " Shortfall amount: " + e.getShortfall());
            }
        }
    }
}
