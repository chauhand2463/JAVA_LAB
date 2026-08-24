abstract class Shape { 
    abstract void area(); 
} 

class Circle extends Shape { 
    float r;
    @Override
    void area() { 
        float a = (float) (3.14 * r * r);
        System.out.println("Circle Area: " + a);
    } 
} 

class Rectangle extends Shape { 
    float l, b;

    @Override 
    void area() { 
        float a = (float) (l * b); 
        System.out.println("Rectangle Area: " + a);
    } 
} 

class Triangle extends Shape { 
    float h, b;

    @Override
    void area() { 
        float a = (float) (0.5 * b * h); 
        System.out.println("Triangle Area: " + a);
    } 
}

public class A{
    public static void main (String args[]){
        Circle c = new Circle();
        Rectangle r = new Rectangle()
        Triangle T = new Triangle();
        shape[] a= {
            c.shape();
            r.shape(),
            T.shape()
        }
    }
}


