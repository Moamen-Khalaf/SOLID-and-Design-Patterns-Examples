package DesignPatterns.StructuralDP.Composite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Box {
    double calculatePrice();
}

abstract class Product implements Box {
    public String titile;
    public double price;

    Product(String title, double price) {
        this.price = price;
        this.titile = title;
    }

    @Override
    public double calculatePrice() {
        return price;
    }
}

class Book extends Product {
    Book(String title, double price) {
        super(title, price);
    }
}

class Phone extends Product {
    Phone(String title, double price) {
        super(title, price);
    }
}

class CompositeBox implements Box {
    public List<Box> items = new ArrayList<Box>();

    CompositeBox(Box... items) {
        this.items.addAll(Arrays.asList(items));
    }

    public void add(Box item) {
        items.add(item);
    }

    public void remove(Box item) {
        items.remove(item);
    }

    @Override
    public double calculatePrice() {
        return items.stream().mapToDouble(e -> e.calculatePrice()).sum();
    }
}

public class AmazonDelivery {
    public static void main(String[] args) {
        Box book1 = new Book("Design Patterns", 45.0);
        Box book2 = new Book("Effective Java", 55.0);
        Box phone1 = new Phone("iPhone", 999.0);
        Box phone2 = new Phone("Samsung Galaxy", 899.0);

        CompositeBox bookBox = new CompositeBox(book1, book2);
        CompositeBox phoneBox = new CompositeBox(phone1, phone2);

        CompositeBox deliveryBox = new CompositeBox(bookBox, phoneBox);

        System.out.println("Total delivery price: " + deliveryBox.calculatePrice());// 1998.0
    }
}
