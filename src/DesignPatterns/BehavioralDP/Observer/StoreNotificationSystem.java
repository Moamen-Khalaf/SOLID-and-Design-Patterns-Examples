package DesignPatterns.BehavioralDP.Observer;

import java.util.ArrayList;
import java.util.List;

interface EventListener {
    void update();
}

class EmailMessageListener implements EventListener {
    private String email;

    public EmailMessageListener(String email) {
        this.email = email;
    }

    @Override
    public void update() {
        System.out.println("Email sent to: " + email);
    }
}

class MobileNotification implements EventListener {
    private String phone;

    public MobileNotification(String phone) {
        this.phone = phone;
    }

    @Override
    public void update() {
        System.out.println("SMS sent to: " + phone);
    }
}

interface IObserver {
    void subscribe(EventListener listener);

    void unsubscribe(EventListener listener);

    void notifyListeners();
}

class NotificationService implements IObserver {
    private List<EventListener> subscribers;

    public NotificationService() {
        subscribers = new ArrayList<>();
    }

    @Override
    public void subscribe(EventListener listener) {
        subscribers.add(listener);
    }

    @Override
    public void unsubscribe(EventListener listener) {
        subscribers.remove(listener);
    }

    @Override
    public void notifyListeners() {
        subscribers.forEach(subscriber -> subscriber.update());
    }

}

class Store {
    private IObserver notificationService;

    public void publishProduct() {
        notificationService.notifyListeners();
    }

    public Store(IObserver observer) {
        notificationService = observer;
    }

    public IObserver getNotificationService() {
        return notificationService;
    }
}

public class StoreNotificationSystem {
    public static void main(String[] args) {
        Store store = new Store(new NotificationService());
        store.getNotificationService().subscribe(new EmailMessageListener("a@a.com"));
        store.getNotificationService().subscribe(new MobileNotification("0123422134"));
        store.publishProduct();
    }
}
