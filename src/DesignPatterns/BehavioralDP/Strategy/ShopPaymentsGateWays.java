package DesignPatterns.BehavioralDP.Strategy;

/*
    Steve goes to a shopping mall and purchases one LED TV and one washing machine and that cost are around 90000 rupees. After purchasing the LED TV
    and Washing Machines, Steve goes to the bill counter and he wants to pay the money.
    There are three different options to pay the money. The options are Credit card, Debit
    Card and Cash. So, from these three options, he has to choose one option and pay
    the money at the bill counter. Suggest a design pattern that could solve this problem?
    Write a mock implementation for your suggested design pattern
*/
interface IPaymentMethod {
    void pay(double amount);
}

// Credit card, Debit Card and Cash
abstract class CardPayment implements IPaymentMethod {
    protected String name;
    protected double balance;

    public CardPayment(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public boolean checkBalance(double amount) {
        return balance >= amount;
    }

    @Override
    public abstract void pay(double amount);
}

class CreditCard extends CardPayment {

    public CreditCard(String name, double balance) {
        super(name, balance);
    }

    @Override
    public void pay(double amount) {
        double total = amount + amount * 0.02;
        if (this.checkBalance(total)) {
            balance -= total;
        }
    }
}

class DebitCard extends CardPayment {

    public DebitCard(String name, double balance) {
        super(name, balance);
    }

    @Override
    public void pay(double amount) {
        double total = amount + amount * 0.01;
        if (this.checkBalance(total)) {
            balance -= total;
        }
    }
}

class Cash implements IPaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " in cash.");
    }
}

class Mall {
    private IPaymentMethod paymentStrategy;

    public Mall(IPaymentMethod paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void setPaymentStrategy(IPaymentMethod paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(double amount) {
        paymentStrategy.pay(amount);
    }
}

public class ShopPaymentsGateWays {
    public static void main(String[] args) {
        IPaymentMethod paymentMethod = new CreditCard("Steve", 100000);
        Mall mall = new Mall(paymentMethod);
        mall.processPayment(90000);
    }
}
