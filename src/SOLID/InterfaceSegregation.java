package SOLID;

//! 4. Interface Segregation Principle (ISP)
//! Clients should not be forced to implement interfaces they do not use.
interface IWorker {
    void work();

    void eat();
}

class HumanWorker implements IWorker {
    @Override
    public void work() {
        System.out.println("HumanWorker is working");
    }

    @Override
    public void eat() {
        System.out.println("HumanWorker is eating");
    }
}

class RobotWorker implements IWorker {

    @Override
    public void work() {
        System.out.println("RobotWorker is working");
    }

    @Override
    public void eat() {
        throw new UnsupportedOperationException("RobotWorker cannot eat");
    }

}

// Fix: Split the interface.
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class HumanWorker2 implements Workable, Eatable {
    @Override
    public void work() {
        System.out.println("HumanWorker2 is working");
    }

    @Override
    public void eat() {
        System.out.println("HumanWorker2 is eating");
    }
}

class RobotWorker2 implements Workable {
    @Override
    public void work() {
        System.out.println("RobotWorker2 is working");
    }
}

public class InterfaceSegregation {
    public static void main(String[] args) {
        // HumanWorker humanWorker = new HumanWorker();
        // humanWorker.work();
        // humanWorker.eat();
        // RobotWorker robotWorker = new RobotWorker();
        // robotWorker.work();
        // ! robotWorker.eat(); // This will throw an exception

        HumanWorker2 humanWorker2 = new HumanWorker2();
        humanWorker2.work();
        humanWorker2.eat();
        RobotWorker2 robotWorker2 = new RobotWorker2();
        robotWorker2.work();
    }
}
