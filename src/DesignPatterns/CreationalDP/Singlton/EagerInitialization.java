package DesignPatterns.CreationalDP.Singlton;

class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return Singleton.instance;
    }

    public void print() {
        System.out.println("Hello");
    }
}

public class EagerInitialization {
    public static void main(String[] args) {
        Singleton.getInstance().print();
    }
}
