package com.gradlehero;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IceCreamStandTest {
    private final IceCreamStand iceCreamStand = new IceCreamStand();

    @Test
    public void canBuyStandardIceCream() {
        assertNotNull(iceCreamStand.buyIceCream());
    }

    @Test
    public void canBuyIceCreamWithFlake() {
        assertNotNull(iceCreamStand.buyIceCreamWithFlake());
    }

    @Test
    public void canBuyAllTheIceCreams() {
        for (int i = 0; i < 100; i++) {
            iceCreamStand.buyIceCream();
        }
        IllegalStateException exception = assertThrows(IllegalStateException.class, iceCreamStand::buyIceCream);

        assertEquals("Sorry, we're out of ice cream!", exception.getMessage());
    }
}
