import java.util.Scanner;

abstract class Shape {
    abstract void area();
}

class Circle extends Shape {
    float r;

    Circle(float r) {
        this.r = r;
    }

    @Override
    void area() {
        float a = (float) (3.14 * r * r);
        System.out.println("Circle Area: " + a);
    }
}

class Rectangle extends Shape {
    float l, b;

    Rectangle(float l, float b) {
        this.l = l;
        this.b = b;
    }

    @Override
    void area() {
        float a = l * b;
        System.out.println("Rectangle Area: " + a);
    }
}

class Triangle extends Shape {
    float h, b;

    Triangle(float h, float b) {
        this.h = h;
        this.b = b;
    }

    @Override
    void area() {
        float a = (float) (0.5 * b * h);
        System.out.println("Triangle Area: " + a);
    }
}

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter radius of circle: ");
        float radius = sc.nextFloat();

        System.out.print("Enter length of rectangle: ");
        float length = sc.nextFloat();

        System.out.print("Enter breadth of rectangle: ");
        float breadth = sc.nextFloat();

        System.out.print("Enter height of triangle: ");
        float height = sc.nextFloat();

        Circle c = new Circle(radius);
        Rectangle r = new Rectangle(length, breadth);
        Triangle t = new Triangle(height, breadth);

        Shape[] a = {c, r, t};

        System.out.println("Dhairy Chauhan 25CE015");

        for (Shape s : a) {
            s.area();
        }

        sc.close();
    }
}