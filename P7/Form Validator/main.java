import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.Scanner;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotBlank {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class UserForm {
    @NotBlank
    String name;

    @MaxLength(10)
    String city;

    UserForm(String name, String city) {
        this.name = name;
        this.city = city;
    }
}

public class main{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your city: ");
        String city = sc.nextLine();

        UserForm user = new UserForm(name, city);
        List<String> errors = new LinkedList<>();

        for (Field field : user.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(user);

            if (field.isAnnotationPresent(NotBlank.class)) {
                if (value == null || value.toString().trim().isEmpty()) {
                    errors.add(field.getName() + " cannot be blank");
                }
            }

            if (field.isAnnotationPresent(MaxLength.class)) {
                int max = field.getAnnotation(MaxLength.class).value();

                if (value != null && value.toString().length() > max) {
                    errors.add(field.getName() + " must not exceed " + max + " characters");
                }
            }
        }

        if (errors.isEmpty()) {
            System.out.println("Form is valid");
        } else {
            System.out.println("Form validation failed:");
            for (String error : errors) {
                System.out.println(error);
            }
        }
        System.out.println("Dhairy Chauhan 25CE015");

        sc.close();
    }
}
