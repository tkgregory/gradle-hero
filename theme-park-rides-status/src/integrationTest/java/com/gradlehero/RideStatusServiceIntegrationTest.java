package com.gradlehero;

import com.gradlehero.themepark.RideStatusService;
import org.junit.jupiter.api.Test;

public class RideStatusServiceIntegrationTest {
    @Test
    public void testMainMethod() {
        RideStatusService.main(new String[]{"teacups"});
    }
}