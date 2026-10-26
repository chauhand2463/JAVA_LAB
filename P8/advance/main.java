class MyResource implements AutoCloseable {
    public MyResource() {
        System.out.println("Resource opened");
    }

    public void use() {
        System.out.println("Performing operation");
        throw new RuntimeException("Original operation failed");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing resource");
        throw new Exception("Error while closing resource");
    }
}

public class main{
    public static void main(String[] args) {
        try (MyResource r = new MyResource()) {
            r.use();
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());

            for (Throwable t : e.getSuppressed()) {
                System.out.println("Suppressed exception: " + t.getMessage());
            }
        }

        System.out.println("Dhairy Chauhan 24CE015");
    }
}
