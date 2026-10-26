import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Column {
    String name();
}

class Student {
    @Column(name = "name")
    String name;

    @Column(name = "age")
    String age;

    @Column(name = "city")
    String city;
}

public class main{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter column names separated by commas:");
        String[] header = sc.nextLine().split(",");

        System.out.println("Enter values in the same order:");
        String[] data = sc.nextLine().split(",", -1);

        if (header.length != data.length) {
            System.out.println("Error: Number of columns and values do not match");
            sc.close();
            return;
        }

        Student s = new Student();

        for (Field f : Student.class.getDeclaredFields()) {
            Column c = f.getAnnotation(Column.class);

            if (c != null) {
                for (int i = 0; i < header.length; i++) {
                    if (header[i].trim().equals(c.name())) {
                        f.setAccessible(true);
                        f.set(s, data[i].trim());
                        break;
                    }
                }
            }
        }

        System.out.println("\nStudent Details:");
        System.out.println("Name: " +
            (s.name == null ? "Missing column" : s.name));
        System.out.println("Age: " +
            (s.age == null ? "Missing column" : s.age));
        System.out.println("City: " +
            (s.city == null ? "Missing column" : s.city));
        System.out.println("Rahil Butani 25CE011");
        sc.close();
    }
}
