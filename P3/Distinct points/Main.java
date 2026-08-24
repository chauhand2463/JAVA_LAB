import java.util.Objects;
import java.util.Scanner;

class Point {
    private int x;
    private int y;

    public P(int xVal, int yVal) {
        this.x = xVal;
        this.y = yVal;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int xVal = sc.nextInt();
        int yVal = sc.nextInt();

        P p = new P(xVal, yVal);

        System.out.println(p);
        sc.close();
    }
}
