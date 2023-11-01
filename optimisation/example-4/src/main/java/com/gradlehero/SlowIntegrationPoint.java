package com.gradlehero;

public class SlowIntegrationPoint {
    public void doSomething() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
