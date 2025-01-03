package DesignPatterns.BehavioralDP.Strategy;

interface FlyBehavior {
    void fly();
}

abstract class Duck {
    private FlyBehavior flyBehavior;

    public Duck(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    abstract void display();

    public void fly() {
        flyBehavior.fly();
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }
}

class FlyWithWingsBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("flying with wings");
    }
}

class NotFlyableBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("cannot fly");
    }
}

class RubberDuck extends Duck {

    public RubberDuck(FlyBehavior flyBehavior) {
        super(flyBehavior);
    }

    @Override
    void display() {
        System.out.println("RubberDuck displayed");
    }

}

class MallardDuck extends Duck {

    public MallardDuck(FlyBehavior flyBehavior) {
        super(flyBehavior);
    }

    @Override
    void display() {
        System.out.println("MallardDuck displayed");
    }

}

// RubberDuck,MallardDuck
public class DuckStrategy {
    public static void main(String[] args) {
        Duck rubberDuck = new RubberDuck(new NotFlyableBehavior());
        rubberDuck.display();
        rubberDuck.fly();

        Duck mallardDuck = new MallardDuck(new FlyWithWingsBehavior());
        mallardDuck.display();
        mallardDuck.fly();

        // Change the fly behavior of the rubber duck at runtime
        rubberDuck.setFlyBehavior(new FlyWithWingsBehavior());
        rubberDuck.fly();
    }
}
