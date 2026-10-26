import java.lang.annotation.*;

import java.lang.reflect.*;

 

@Retention(RetentionPolicy.RUNTIME)

@Target(ElementType.METHOD)

@interface Run {}

 

class TestCases {

    @Run

    public void testAddition() {

        System.out.println("Addition test passed");

    }

 

    @Run

    public void testSubtraction() {

        System.out.println("Subtraction test passed");

    }

 

    public void ignoredMethod() {

        System.out.println("This method should not run");

    }

}

 

public class main {

    public static void main(String[] args) throws Exception {

        TestCases tests = new TestCases();

        int count = 0;

 

        for (Method method : tests.getClass().getDeclaredMethods()) {

            if (method.isAnnotationPresent(Run.class)) {

                method.invoke(tests);

                count++;

            }

        }

 

        System.out.println("Tests run: " + count);

        System.out.println("Dhairy Chauhan 25CE015");

    }

}
