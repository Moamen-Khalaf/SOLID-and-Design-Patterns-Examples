package SOLID;

//* 1. Single Responsibility Principle (SRP)
//! A class should have one and only one reason to change.
class UserManager {
    public String name;

    // ! This class has two responsibilities: creating a user and sending an email.
    public void createUser(String name) {
        this.name = name;
        sendEmail("Welcome to our website!");
    }

    public void sendEmail(String message) {
        System.out.println("Email sent to " + this.name + " with message: " + message);
    }
}

// FIX: Separate the concerns
class UserCreator {
    public String name;
    public String email;

    public void createUser(String name) {
        this.name = name;
    }
}

class EmailService {
    public void sendEmail(String email) {
        System.out.println("Email sent to " + email);
    }
}

public class SingleResponsibility {
    public static void main(String[] args) {
        UserCreator userCreator = new UserCreator();
        userCreator.createUser("John Doe");

        EmailService emailService = new EmailService();
        emailService.sendEmail("email@gma.com");

    }
}
