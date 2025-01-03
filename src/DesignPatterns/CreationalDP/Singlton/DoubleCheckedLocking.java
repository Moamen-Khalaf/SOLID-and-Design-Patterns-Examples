package DesignPatterns.CreationalDP.Singlton;

class SingletonThreadSaveBestPerformance {
    private static SingletonThreadSaveBestPerformance instance;
    private final String URL;

    private SingletonThreadSaveBestPerformance(String URL) {
        this.URL = URL;
    }

    public void connectToDB() {
        System.out.println("Connecting to database at " + URL);
    }

    public static SingletonThreadSaveBestPerformance getInstance(String URL) {
        if (SingletonThreadSaveBestPerformance.instance == null) {
            synchronized (SingletonThreadSaveBestPerformance.class) {
                if (SingletonThreadSaveBestPerformance.instance == null) {
                    SingletonThreadSaveBestPerformance.instance = new SingletonThreadSaveBestPerformance(URL);
                }
            }
        }
        return SingletonThreadSaveBestPerformance.instance;
    }
}

public class DoubleCheckedLocking {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            public void run() {
                SingletonThreadSaveBestPerformance inst = SingletonThreadSaveBestPerformance
                        .getInstance("https://plapla.org");
                inst.connectToDB();
            };
        };
        Thread t2 = new Thread() {
            public void run() {
                SingletonThreadSaveBestPerformance inst = SingletonThreadSaveBestPerformance
                        .getInstance("https://nahnah.org");
                inst.connectToDB();
            };
        };
        t1.start();
        t2.start();
    }
}
