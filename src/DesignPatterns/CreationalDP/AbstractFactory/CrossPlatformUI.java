package DesignPatterns.CreationalDP.AbstractFactory;

interface Button {
    void render();
}

interface CheckBox {
    void render();
}

class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Windows Button");
    }
}

class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Mac Button");
    }
}

class WindowsCheckBox implements CheckBox {
    @Override
    public void render() {
        System.out.println("Rendering Windows CheckBox");
    }
}

class MacCheckBox implements CheckBox {
    @Override
    public void render() {
        System.out.println("Rendering Mac CheckBox");
    }
}

abstract class Dialog {
    abstract Button createButton();

    abstract CheckBox createCheckBox();

    public void render() {
        Button btn = createButton();
        CheckBox cbx = createCheckBox();
        btn.render();
        cbx.render();
    }
}

class WindowsDialog extends Dialog {
    @Override
    Button createButton() {
        return new WindowsButton();
    }

    @Override
    CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }
}

class MacDialog extends Dialog {
    @Override
    Button createButton() {
        return new MacButton();
    }

    @Override
    CheckBox createCheckBox() {
        return new MacCheckBox();
    }
}

public class CrossPlatformUI {
    public static void main(String[] args) {
        Dialog dialog;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("win")) {
            dialog = new WindowsDialog();
        } else {
            dialog = new MacDialog();
        }
        dialog.render();
    }
}
