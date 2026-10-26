class Box<T> {
    private T value;

    void set(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }
}

class Pair<A, B> {
    A first;
    B second;

    Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    void display() {
        System.out.println(first + " - " + second);
    }
}

public class main{
    static <T> T first(T[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        return arr[0];
    }

    public static void main(String[] args) {
        Box<String> name = new Box<>();
        name.set("Rahil");

        Box<Integer> marks = new Box<>();
        marks.set(95);

        System.out.println("Name: " + name.get());
        System.out.println("Marks: " + marks.get());

        Pair<String, Integer> student =
                new Pair<>("Rahil", 25);
        student.display();

        String[] names = {"Aman", "Rahil", "Priya"};
        Integer[] numbers = {10, 20, 30};

        System.out.println("First name: " + first(names));
        System.out.println("First number: " + first(numbers));
        System.out.println("Dhairy Chauhan 25CE015");
    }
}
