package com.gradlehero;

public class IceCreamStand {
    private int iceCreamCount = 100;

    public IceCream buyIceCream() {
        validateStock();
        iceCreamCount--;
        return new IceCream("vanilla", false);
    }

    public IceCream buyIceCreamWithFlake() {
        validateStock();
        iceCreamCount--;
        return new IceCream("vanilla", true);
    }

    public IceCream buyChocotasticIceCream() {
        validateStock();
        iceCreamCount--;
        return new IceCream("chocolate", true);
    }

    private void validateStock() {
        if (iceCreamCount == 0) {
            throw new IllegalStateException("Sorry, we're out of ice cream!");
        }
    }
}
