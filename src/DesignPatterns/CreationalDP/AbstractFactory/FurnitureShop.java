package DesignPatterns.CreationalDP.AbstractFactory;

// Chair + Sofa + CoffeeTable
interface Chair {
    void sitOn();
}

interface Sofa {
    void lieOn();
}

interface CoffeeTable {
    void placeItemsOn();
}

// Modern, Victorian, ArtDeco
class ModernChair implements Chair {
    @Override
    public void sitOn() {

    }
}

class VictorianChair implements Chair {
    @Override
    public void sitOn() {

    }
}

class ArtDecoChair implements Chair {
    @Override
    public void sitOn() {

    }
}

class ModernSofa implements Sofa {
    @Override
    public void lieOn() {

    }
}

class VictorianSofa implements Sofa {
    @Override
    public void lieOn() {

    }
}

class ArtDecoSofa implements Sofa {
    @Override
    public void lieOn() {

    }
}

class ModernCoffeeTable implements CoffeeTable {
    @Override
    public void placeItemsOn() {

    }
}

class VictorianCoffeeTable implements CoffeeTable {
    @Override
    public void placeItemsOn() {

    }
}

class ArtDecoCoffeeTable implements CoffeeTable {
    @Override
    public void placeItemsOn() {

    }
}

abstract class FurnitureFactory {
    abstract public Chair ceateChair();

    abstract public Sofa createSofa();

    abstract public CoffeeTable createCoffeeTable();
}

class ModernFactory extends FurnitureFactory {
    @Override
    public Chair ceateChair() {
        return new ModernChair();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new ModernCoffeeTable();
    }

    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }
}

class VictorianFactory extends FurnitureFactory {
    @Override
    public Chair ceateChair() {
        return new VictorianChair();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new VictorianCoffeeTable();
    }

    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }
}

class ArtDecoFactory extends FurnitureFactory {
    @Override
    public Chair ceateChair() {
        return new ArtDecoChair();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new ArtDecoCoffeeTable();
    }

    @Override
    public Sofa createSofa() {
        return new ArtDecoSofa();
    }
}

public class FurnitureShop {
    public static void main(String[] args) {
        FurnitureFactory factory;
        Chair chair;
        Sofa sofa;
        CoffeeTable coffeeTable;

        // Example usage with ModernFactory
        factory = new ModernFactory();
        chair = factory.ceateChair();
        sofa = factory.createSofa();
        coffeeTable = factory.createCoffeeTable();

        chair.sitOn();
        sofa.lieOn();
        coffeeTable.placeItemsOn();

        // Example usage with VictorianFactory
        factory = new VictorianFactory();
        chair = factory.ceateChair();
        sofa = factory.createSofa();
        coffeeTable = factory.createCoffeeTable();

        chair.sitOn();
        sofa.lieOn();
        coffeeTable.placeItemsOn();

        // Example usage with ArtDecoFactory
        factory = new ArtDecoFactory();
        chair = factory.ceateChair();
        sofa = factory.createSofa();
        coffeeTable = factory.createCoffeeTable();

        chair.sitOn();
        sofa.lieOn();
        coffeeTable.placeItemsOn();
    }
}
