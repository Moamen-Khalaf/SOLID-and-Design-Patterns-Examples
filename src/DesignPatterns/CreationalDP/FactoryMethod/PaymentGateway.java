package DesignPatterns.CreationalDP.FactoryMethod;

import java.util.Random;
import java.util.UUID;

/*
    Detailed Scenario
    Imagine you are building an e-commerce platform that needs to handle payments through multiple payment gateways such as PayPal, Stripe, and Square. Each gateway has different ways of processing payments, but your platform needs a unified interface to interact with them.

    This is where the Factory Method Pattern can help by allowing you to create objects of different payment gateways (PayPal, Stripe, Square) through a factory, without changing the client code. 

 */
interface IBankAccount {
    void deposit(double amount);

    void pay(double amount) throws Exception;

    void activate();
}

interface IPaymentGateway {
    double getFees(double amount);
}

class RegularBankAccount implements IBankAccount {
    private static int counterId = 0;

    private final String cardId;
    private final int userId;

    private String name;
    private double balance;
    private boolean active;

    public RegularBankAccount(String name) {
        this.userId = ++counterId;
        balance = 0;
        active = false;
        this.name = name;
        this.cardId = UUID.randomUUID().toString();
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public void activate() {
        active = true;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void pay(double amount) throws Exception {
        if (amount > balance) {
            throw new Exception("Insufficient balance");
        }
        System.out.println("Payment of " + amount + " processed. Remaining balance: " + (balance - amount));
        balance -= amount;
    }
}

class PayPal implements IPaymentGateway {
    public final double fees = 0.02;

    @Override
    public double getFees(double amount) {
        return amount * fees;
    }
}

class Stripe implements IPaymentGateway {
    public final double fees = 0.012;

    @Override
    public double getFees(double amount) {
        return amount * fees;
    }
}

class Square implements IPaymentGateway {
    public final double fees = 0.022;

    @Override
    public double getFees(double amount) {
        return amount * fees;
    }
}

abstract class PaymentGatewayFactory {
    public abstract IPaymentGateway createPaymentGateway();

    public void pay(IBankAccount account, double amount) {
        IPaymentGateway gateway = createPaymentGateway();
        double fees = gateway.getFees(amount);
        try {
            account.pay(amount + fees);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class PayPalFactory extends PaymentGatewayFactory {
    @Override
    public IPaymentGateway createPaymentGateway() {
        return new PayPal();
    }
}

class StripeFactory extends PaymentGatewayFactory {
    @Override
    public IPaymentGateway createPaymentGateway() {
        return new Stripe();
    }
}

class SquareFactory extends PaymentGatewayFactory {
    @Override
    public IPaymentGateway createPaymentGateway() {
        return new Square();
    }
}

public class PaymentGateway {
    public static void main(String[] args) {
        RegularBankAccount account = new RegularBankAccount("Jon Doe");
        account.deposit(5000);
        account.activate();
        PaymentGatewayFactory paypal = new PayPalFactory();
        paypal.pay(account, 200);
        PaymentGatewayFactory stripe = new StripeFactory();
        stripe.pay(account, 200);
        PaymentGatewayFactory square = new SquareFactory();
        square.pay(account, 200);
    }
}
