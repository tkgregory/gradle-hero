package com.gradlehero;

public class Application {
    private final SlowIntegrationPoint slowIntegrationPoint;

    public Application() {
        slowIntegrationPoint = new SlowIntegrationPoint();
    }

    public void doSomething() {
        slowIntegrationPoint.doSomething();
    }
}
