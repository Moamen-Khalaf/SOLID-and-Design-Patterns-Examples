package DesignPatterns.StructuralDP.Composite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Graphic {
    void move(int x, int y);

    void draw();

}

class Dot implements Graphic {
    public int x;
    public int y;

    Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public void draw() {
        System.out.println("Dot at (" + x + ", " + y + ")");
    }
}

class CompoundGraphic implements Graphic {
    public List<Graphic> children = new ArrayList<Graphic>();

    public CompoundGraphic(Graphic... graphics) {
        children.addAll(Arrays.asList(graphics));
    }

    @Override
    public void draw() {
        children.stream().forEach(graphic -> graphic.draw());
    }

    @Override
    public void move(int x, int y) {
        children.stream().forEach(graphic -> graphic.move(x, y));
    }

    public void add(Graphic graphic) {
        this.children.add(graphic);
    }

    public void remove(Graphic graphic) {
        this.children.remove(graphic);
    }
}

class Circle extends Dot {
    public int radius;

    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Circle at (" + x + ", " + y + ") with radius " + radius);
    }
}

public class GeometricShapesEditor {
    public static void main(String[] args) {
        Graphic editor = new CompoundGraphic(
                new Circle(2, 3, 10),
                new Dot(5, 5),
                new CompoundGraphic(
                        new Dot(0, 0),
                        new Dot(0, 4),
                        new Dot(4, 0),
                        new Dot(4, 4)));
        editor.draw();
        System.out.println("-------");
        editor.move(4, 2);
        editor.draw();
    }
}
