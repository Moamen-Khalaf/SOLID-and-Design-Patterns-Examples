package SOLID;

//* 2. Open/Closed Principle (OCP)
//* Software entities should be open for extension but closed for modification.
class DiscountCalculator {
    // ! This class violates the Open/Closed Principle because if we want to add a
    // ! new discount type, we have to modify the existing code.
    public int calculateDiscount(String type) {
        if (type == "regular") {
            return 10;
        } else if (type == "vip") {
            return 20;
        }
        return 0;
    }
}

// * FIX: Implement the Open/Closed Principle
interface DiscountType {
    int calculate();
}

class RegularDiscount implements DiscountType {
    public int calculate() {
        return 10;
    }
}

class VIPDiscount implements DiscountType {
    public int calculate() {
        return 20;
    }
}

class DiscountCalculatorOCP {
    public int calculateDiscount(DiscountType discountType) {
        return discountType.calculate();
    }
}

public class OpenClosed {
    public static void main(String[] args) {
        // ! DiscountCalculator dc = new DiscountCalculator();
        // ! System.out.println(dc.calculateDiscount("regular"));
        // ! System.out.println(dc.calculateDiscount("vip"));

        DiscountCalculatorOCP dco = new DiscountCalculatorOCP();
        System.out.println(dco.calculateDiscount(new RegularDiscount()));
        System.out.println(dco.calculateDiscount(new VIPDiscount()));
    }
}
