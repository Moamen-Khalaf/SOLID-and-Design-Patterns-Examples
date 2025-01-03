package DesignPatterns.CreationalDP.Singlton;

class SingletonThreadSave {
    private static SingletonThreadSave instance;
    private final String URL;

    private SingletonThreadSave(String URL) {
        this.URL = URL;
    }

    public void connectToDB() {
        System.out.println("Connecting to database at " + URL);
    }

    public static synchronized SingletonThreadSave getInstance(String URL) {
        if (SingletonThreadSave.instance == null) {
            SingletonThreadSave.instance = new SingletonThreadSave(URL);
        }
        return SingletonThreadSave.instance;
    }
}

public class ThreadSafeWithSynchronization {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            public void run() {
                SingletonThreadSave inst = SingletonThreadSave.getInstance("https://plapla.org");
                inst.connectToDB();
            };
        };
        Thread t2 = new Thread() {
            public void run() {
                SingletonThreadSave inst = SingletonThreadSave.getInstance("https://nahnah.org");
                inst.connectToDB();
            };
        };
        t1.start();
        t2.start();
    }
}
