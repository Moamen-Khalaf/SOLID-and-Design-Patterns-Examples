package DesignPatterns.CreationalDP.AbstractFactory;

interface GPU {
    void assemble();
}

interface Monitor {
    void assemble();
}

class MsiGPU implements GPU {
    @Override
    public void assemble() {
    }
}

class AsusGPU implements GPU {
    @Override
    public void assemble() {
    }
}

class MsiMonitor implements Monitor {
    @Override
    public void assemble() {
    }
}

class AsusMonitor implements Monitor {
    @Override
    public void assemble() {
    }
}

abstract class CompanyFactory {
    public abstract GPU createGpu();

    public abstract Monitor createMonitor();

    public void shipeGPU() {
        GPU gpu = createGpu();
        gpu.assemble();
    }

    public void shipeMonitor() {
        Monitor monitor = createMonitor();
        monitor.assemble();
    }
}

class MsiManufactory extends CompanyFactory {
    @Override
    public GPU createGpu() {
        return new MsiGPU();
    }

    @Override
    public Monitor createMonitor() {
        return new MsiMonitor();
    }
}

class AsusManufactory extends CompanyFactory {
    @Override
    public GPU createGpu() {
        return new AsusGPU();
    }

    @Override
    public Monitor createMonitor() {
        return new AsusMonitor();
    }
}

public class ComputerStore {
    public static void main(String[] args) {
        CompanyFactory msiFactory = new MsiManufactory();
        msiFactory.shipeGPU();
        msiFactory.shipeMonitor();

        CompanyFactory asusFactory = new AsusManufactory();
        asusFactory.shipeGPU();
        asusFactory.shipeMonitor();
    }
}
