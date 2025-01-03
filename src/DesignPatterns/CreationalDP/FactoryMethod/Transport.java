package DesignPatterns.CreationalDP.FactoryMethod;

interface ITransport {
    void deliver();
}

class Truck implements ITransport {
    @Override
    public void deliver() {
        System.out.println("Deliver using Truck");
    }
}

class Ship implements ITransport {
    @Override
    public void deliver() {
        System.out.println("Deliver using Ship");
    }
}

abstract class Logistics {
    public void planDelivery() {
        ITransport transport = createTransport();
        transport.deliver();
    }

    public abstract ITransport createTransport();
}

class SeaLogistics extends Logistics {
    @Override
    public ITransport createTransport() {
        return new Ship();
    }
}

class RoadLogistics extends Logistics {
    @Override
    public ITransport createTransport() {
        return new Truck();
    }
}

public class Transport {
    public static void main(String[] args) {
        Logistics sea = new SeaLogistics();
        sea.planDelivery();
        Logistics road = new RoadLogistics();
        road.planDelivery();
    }
}
