package DesignPatterns.BehavioralDP.Observer;

import java.util.ArrayList;
import java.util.List;

interface IObserver {
    void change(IPublisher publisher);
}

interface IWindow {
    void draw();
}

interface IPublisher {
    String request();

    void change();

    void subscribe(IObserver observer);

    void unsubscribe(IObserver observer);
}

abstract class Window implements IObserver, IWindow {
    private String data;

    @Override
    public void change(IPublisher publisher) {
        this.data = publisher.request();
        draw();
    }

    public String getData() {
        return data;
    }

    @Override
    public abstract void draw();
}

class TableWindow extends Window {
    @Override
    public void draw() {
        System.out.println("TableWindow: " + getData());
    }
}

class ChartWindow extends Window {
    @Override
    public void draw() {
        System.out.println("ChartWindow: " + getData());
    }
}

class PieChartWindow extends Window {
    @Override
    public void draw() {
        System.out.println("PieChartWindow: " + getData());
    }
}

class NewsNotificationSystem implements IPublisher {
    private String data;
    private List<IObserver> subscribers;

    public NewsNotificationSystem() {
        subscribers = new ArrayList<>();
    }

    @Override
    public void change() {
        subscribers.forEach(subscriber -> subscriber.change(this));
    }

    @Override
    public String request() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
        change();
    }

    @Override
    public void subscribe(IObserver observer) {
        subscribers.add(observer);
    }

    @Override
    public void unsubscribe(IObserver observer) {
        subscribers.remove(observer);
    }
}

public class NewsSystem {
    public static void main(String[] args) {
        NewsNotificationSystem notificationSystem = new NewsNotificationSystem();
        notificationSystem.subscribe(new PieChartWindow());
        notificationSystem.subscribe(new TableWindow());
        notificationSystem.subscribe(new ChartWindow());
        notificationSystem.setData("{a:55,b:22,c:13}");
    }
}
