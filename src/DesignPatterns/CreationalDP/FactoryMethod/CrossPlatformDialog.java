package DesignPatterns.CreationalDP.FactoryMethod;

interface Button {
    void render();

    void onClick();
}

class WindowsButton implements Button {
    @Override
    public void onClick() {
        // TODO Auto-generated method stub

    }

    @Override
    public void render() {
        // TODO Auto-generated method stub
    }
}

class HTMLButton implements Button {
    @Override
    public void onClick() {
        // TODO Auto-generated method stub

    }

    @Override
    public void render() {
        // TODO Auto-generated method stub
    }
}

abstract class Dialog {
    public void render() {
        Button btn = createButton();
        btn.render();
    }

    public abstract Button createButton();
}

class WindowsDialog extends Dialog {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}

class HTMLDialog extends Dialog {
    @Override
    public Button createButton() {
        return new HTMLButton();
    }
}

public class CrossPlatformDialog {
    public static void main(String[] args) {
        Dialog win = new WindowsDialog();
        win.render();
        Dialog htmx = new HTMLDialog();
        htmx.render();
    }
}
