package SOLID;

// * 3. Liskov Substitution Principle (LSP)
// * Subtypes must be substitutable for their base types.
class Rectangle {
    protected int width, height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

class Square extends Rectangle {
    public Square(int size) {
        super(size, size);
    }
}

// * fix: The Square class should not inherit from the Rectangle class because
// * the Square class does not follow the Liskov Substitution Principle.
interface Shape {
    int getArea();
}

class RectangleLSP implements Shape {
    protected int width, height;

    public RectangleLSP(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}

class SquareLSP implements Shape {
    private int size;

    public SquareLSP(int size) {
        this.size = size;
    }

    public int getArea() {
        return size * size;
    }
}

public class LiskovSubstitution {
    public static void main(String[] args) {
        // ! Rectangle rc = new Rectangle(2, 3);
        // ! System.out.println(rc.getArea());

        // ! Rectangle sq = new Square(2);
        // ! sq.setWidth(3);
        // ! System.out.println(sq.getArea());

        Shape rc = new RectangleLSP(2, 3);
        System.out.println(rc.getArea());
        Shape sq = new SquareLSP(2);
        System.out.println(sq.getArea());
    }
}
