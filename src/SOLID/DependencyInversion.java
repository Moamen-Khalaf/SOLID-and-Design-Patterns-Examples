package SOLID;

// * 5. Dependency Inversion Principle (DIP)
// * High-level modules should not depend on low-level modules. Both should depend on abstractions.
class BackendDeveloper {
    public void develop() {
        System.out.println("Writing backend code...");
    }
}

class FrontendDeveloper {
    public void develop() {
        System.out.println("Writing backend code...");
    }
}

class Project {
    // ! This class violates the Dependency Inversion Principle because it depends
    // ! on the concrete classes BackendDeveloper and FrontendDeveloper.
    private BackendDeveloper backendDeveloper;
    private FrontendDeveloper frontendDeveloper;

    Project(BackendDeveloper backendDeveloper, FrontendDeveloper frontendDeveloper) {
        this.backendDeveloper = backendDeveloper;
        this.frontendDeveloper = frontendDeveloper;
    }

    public void implement() {
        backendDeveloper.develop();
        frontendDeveloper.develop();
    }
}

// *Fix: Create an interface for the developers.
interface Developer {
    void develop();
}

class BackendDeveloperDIP implements Developer {
    @Override
    public void develop() {
        System.out.println("Writing backend code...");
    }
}

class FrontendDeveloperDIP implements Developer {
    @Override
    public void develop() {
        System.out.println("Writing frontend code...");
    }
}

class ProjectDIP {
    private Developer backendDeveloper;
    private Developer frontendDeveloper;

    ProjectDIP(Developer backendDeveloper, Developer frontendDeveloper) {
        this.backendDeveloper = backendDeveloper;
        this.frontendDeveloper = frontendDeveloper;
    }

    public void implement() {
        backendDeveloper.develop();
        frontendDeveloper.develop();
    }
}

public class DependencyInversion {
    public static void main(String[] args) {
        // ! BackendDeveloper backendDeveloper = new BackendDeveloper();
        // ! FrontendDeveloper frontendDeveloper = new FrontendDeveloper();
        // ! Project project = new Project(backendDeveloper, frontendDeveloper);
        // ! project.implement();

        Developer backendDeveloper = new BackendDeveloperDIP();
        Developer frontendDeveloper = new FrontendDeveloperDIP();
        ProjectDIP project = new ProjectDIP(backendDeveloper, frontendDeveloper);
        project.implement();

    }
}
