import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    String name;
    int marks;
    transient String password;

    Student(String name, int marks, String password) {
        this.name = name;
        this.marks = marks;
        this.password = password;
    }

    public String toString() {
        return name + " marks=" + marks + " password=" + password;
    }
}

public class Save {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student[] students = {
            new Student("Aarav", 88, "s3cret-a"),
            new Student("Bhavna", 72, "s3cret-b"),
            new Student("Chirag", 95, "s3cret-c")
        };

        System.out.println("Before saving:");
        for (Student s : students) {
            System.out.println("  " + s);
        }

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("students.dat"))) {
            out.writeObject(students);
        }

        Student[] loaded;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("students.dat"))) {
            loaded = (Student[]) in.readObject();
        }

        System.out.println("\nAfter loading:");
        boolean allMatch = true;
        for (int i = 0; i < loaded.length; i++) {
            System.out.println("  " + loaded[i]);
            if (!loaded[i].name.equals(students[i].name) || loaded[i].marks != students[i].marks) {
                allMatch = false;
            }
        }

        System.out.println("\nPersistent fields (name, marks) survived: " + allMatch);
        System.out.println("transient password survived: " + (loaded[0].password != null));
        System.out.println("(password is transient, so it is not saved and comes back null)");
        System.out.println("Dhairy chauhan 25CE015");
    }
}
