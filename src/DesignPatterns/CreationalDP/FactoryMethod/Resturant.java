package DesignPatterns.CreationalDP.FactoryMethod;

interface Burger {
    void prepare();
}

abstract class Restaurant {
    public Burger order() {
        Burger burger = this.createBurger();
        burger.prepare();
        return burger;
    }

    public abstract Burger createBurger();
}

class BeefBurger implements Burger {

    public BeefBurger() {
    }

    @Override
    public void prepare() {
    }
}

class BeefBurgerResturant extends Restaurant {
    public BeefBurgerResturant() {
        super();
    }

    @Override
    public Burger createBurger() {
        return new BeefBurger();
    }
}

class VeggieBurger implements Burger {

    public VeggieBurger() {
    }

    @Override
    public void prepare() {
    }
}

class VeggieBurgerResturant extends Restaurant {
    @Override
    public Burger createBurger() {
        return new VeggieBurger();
    }
}

public class Resturant {
    public static void main(String[] args) {
        BeefBurgerResturant restaurant1 = new BeefBurgerResturant();
        restaurant1.order();
        VeggieBurgerResturant resturant2 = new VeggieBurgerResturant();
        resturant2.order();
    }
}
