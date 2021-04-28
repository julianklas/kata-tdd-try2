import com.kata.sls.domain.Light;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

// Lights turns on automatically every day at 8 AM and goes off at 11 PM
// The user can cancel the scheduled action
public class LightTests {

    @Test
    public void testLightIsOffByDefault() {
        // Given: a light
        Light aLight = new Light();
        // When: I don 't to anything
        // Then: it's off
        Assert.assertFalse(aLight.isOn());
    }

    @Test
    public void testLightCanBeTurnedOn() {
        // Given: a light
        Light aLight = new Light();

        // When: it's turned on
        aLight.turnOn();

        // Then: it's on
        Assert.assertTrue(aLight.isOn());
    }

    @Test
    public void testLightCanBeTurnedOnAndOff() {
        // Given: a light
        Light aLight = new Light();

        // When: it's turned off and then off
        aLight.turnOn();
        aLight.turnOff();

        // Then: it's off
        Assert.assertFalse(aLight.isOn());
    }

}
