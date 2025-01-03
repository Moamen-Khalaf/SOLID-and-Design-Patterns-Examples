package DesignPatterns.CreationalDP.FactoryMethod;

interface Pizza {
    public void prepare();

    public void bake();

    public void cut();

    public void box();
}

class CheesePizza implements Pizza {
    public void prepare() {
        System.out.println("Preparing Cheese Pizza...");
    }

    public void bake() {
        System.out.println("Baking Cheese Pizza...");
    }

    public void cut() {
        System.out.println("Cutting Cheese Pizza...");
    }

    public void box() {
        System.out.println("Boxing Cheese Pizza...");
    }
}

class PepperoniPizza implements Pizza {
    public void prepare() {
        System.out.println("Preparing Pepperoni Pizza...");
    }

    public void bake() {
        System.out.println("Baking Pepperoni Pizza...");
    }

    public void cut() {
        System.out.println("Cutting Pepperoni Pizza...");
    }

    public void box() {
        System.out.println("Boxing Pepperoni Pizza...");
    }
}

abstract class Restaurant {
    public void orderPizza() {
        Pizza pizza = getPizza();
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
    }

    abstract Pizza getPizza();
}

class CheesePizzaRestaurant extends Restaurant {
    @Override
    Pizza getPizza() {
        return new CheesePizza();
    }
}

class PepperoniPizzaRestaurant extends Restaurant {
    @Override
    Pizza getPizza() {
        return new PepperoniPizza();
    }
}

public class PizzaFactory {
    public static void main(String[] args) {
        Restaurant cheeseRestaurant = new CheesePizzaRestaurant();
        cheeseRestaurant.orderPizza();

        Restaurant pepperoniRestaurant = new PepperoniPizzaRestaurant();
        pepperoniRestaurant.orderPizza();
    }
}
