package DesignPatterns.CreationalDP.FactoryMethod;

interface Shape {
    double calcCircumference();

    double calcArea();
}

class Ellipses implements Shape {
    private double a;
    private double b;

    @Override
    public double calcCircumference() {
        return 2 * Math.PI * Math.sqrt((a * a + b * b) / 2);
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    @Override
    public double calcArea() {
        return Math.PI * a * b;
    }
}

class Trapezoid implements Shape {
    private double a;
    private double b;
    private double h;

    @Override
    public double calcCircumference() {
        double leg = Math.sqrt(Math.pow((a - b) / 2, 2) + Math.pow(h, 2));
        return a + b + 2 * leg;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setH(double h) {
        this.h = h;
    }

    @Override
    public double calcArea() {
        return ((a + b) / 2) * h;
    }
}

class Square implements Shape {
    private double s;

    public Square() {
    }

    public void setS(double s) {
        this.s = s;
    }

    @Override
    public double calcCircumference() {
        return 4 * s;
    }

    @Override
    public double calcArea() {
        return s * s;
    }
}

// Ellipses, Trapezoid, and squares
class ShapeFactory {
    public Shape getInstance(String type) {
        switch (type) {
            case "s":
                return new Square();
            case "t":
                return new Trapezoid();
            default:
                return new Ellipses();
        }
    }

}

class Demo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Trapezoid trapezoid = (Trapezoid) shapeFactory.getInstance("t");
        trapezoid.setA(7);
        trapezoid.setB(3);
        trapezoid.setH(10);

        System.out.println("Circumference: " + trapezoid.calcCircumference());
        System.out.println("Area: " + trapezoid.calcArea());
    }

}