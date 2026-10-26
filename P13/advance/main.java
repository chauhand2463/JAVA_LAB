class MyStack<T> {
    private Object[] items;
    private int top = -1;

    MyStack(int size) {
        items = new Object[size];
    }

    void push(T value) {
        if (top == items.length - 1) {
            System.out.println("Stack is full");
            return;
        }
        items[++top] = value;
    }

    @SuppressWarnings("unchecked")
    T pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return null;
        }
        T value = (T) items[top];
        items[top--] = null;
        return value;
    }

    boolean isEmpty() {
        return top == -1;
    }
}

public class main{
    public static void main(String[] args) {
        MyStack<Integer> numbers = new MyStack<>(5);
        numbers.push(10);
        numbers.push(20);
        numbers.push(30);

        System.out.println("Number popped: " + numbers.pop());
        System.out.println("Number popped: " + numbers.pop());

        MyStack<String> names = new MyStack<>(3);
        names.push("Rahil");
        names.push("Aman");

        System.out.println("Name popped: " + names.pop());
        System.out.println("Name popped: " + names.pop());
        System.out.println("Name popped: " + names.pop());

        System.out.println("Stack empty: " + names.isEmpty());
        System.out.println("Dhairy Chauhan 25CE015");
    }
}
