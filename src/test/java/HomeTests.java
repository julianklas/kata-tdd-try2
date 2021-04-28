import com.kata.sls.domain.Home;
import com.kata.sls.domain.Light;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

// Lights turns on automatically every day at 8 AM and goes off at 11 PM
// The user can cancel the scheduled action
public class HomeTests {

    @Test
    public void testNewHomeHasNoLights() {
        // Given: a home
        Home aHome = new Home();

        // When: I create the home

        // Then: it doesn't have any lights
        Assert.assertEquals(0 , aHome.getLights().size() );
    }

    @Test
    public void testLightsCanBeAddedToHome() {
        // Given: a home and a light
        Home aHome = new Home();
        Light aLight = new Light();

        // When: I create the home and add the light
        aHome.addLight(aLight);

        // Then: the light is there
        Assert.assertEquals(1 , aHome.getLights().size() );
        // and it's the same that I've added
        Assert.assertEquals(aLight , aHome.getLights().get(0) );
    }

    @Test
    public void testLightsAreOffAtSevenAM() {
        // Given: a home, a light, 7AM
        Home aHome = new Home();
        Light aLight = new Light();
        LocalDateTime sevenAM = LocalDateTime.of(2021,04,28,07,00,00);
        aHome.addLight(aLight);

        // When: set the house time to seven AM
        aHome.setTime(sevenAM);

        // Then: the light is off
        Assert.assertFalse( aHome.getLights().get(0).isOn() );
    }

    @Test
    public void testSeveralLightsAreOffBeforeEightAM() {
        // Given: a home, two lights, 7AM
        Home aHome = new Home();
        Light firstLight = new Light();
        Light secondLight = new Light();
        LocalDateTime sevenAM = LocalDateTime.of(2021,04,28,07,00,00);

        // When: add the lights and set the house time to seven AM
        aHome.addLight(firstLight);
        aHome.addLight(secondLight);
        aHome.setTime(sevenAM);

        // Then: the lights are off
        Assert.assertFalse( aHome.getLights().get(0).isOn() );
        Assert.assertFalse( aHome.getLights().get(1).isOn() );
    }

    @Test
    public void testLightsAreOnAtEightAM() {
        // Given: a home, a light, 8AM
        Home aHome = new Home();
        Light aLight = new Light();
        LocalDateTime eightAM = LocalDateTime.of(2021,04,28,8,00,00);

        // When: add the light and set the house time to eight AM
        aHome.addLight(aLight);
        aHome.setTime(eightAM);

        // Then: the light is on
        Assert.assertTrue( aHome.getLights().get(0).isOn() );
    }

    @Test
    public void testLightsAreOnAtNineAM() {
        // Given: a home, a light, 9AM
        Home aHome = new Home();
        Light aLight = new Light();
        LocalDateTime nineAM = LocalDateTime.of(2021,04,28,9,00,00);

        // When: add the light and set the house time to nine AM
        aHome.addLight(aLight);
        aHome.setTime(nineAM);

        // Then: the light is on
        Assert.assertTrue( aHome.getLights().get(0).isOn() );
    }

    @Test
    public void testLightsAreOffAtElevenPM() {
        // Given: a home, a light, 11PM
        Home aHome = new Home();
        Light aLight = new Light();
        LocalDateTime elevenPM = LocalDateTime.of(2021,04,28,23,00,00);

        // When: add the light and set the house time to eleven AM
        aHome.addLight(aLight);
        aHome.setTime(elevenPM);

        // Then: the light is off
        Assert.assertFalse( aHome.getLights().get(0).isOn() );
    }


    @Test
    public void testLightsWhichHaveBeenTurnedOnAreOffAtElevenPM() {
        // Given: a home, a light, 11PM
        Home aHome = new Home();
        Light aLight = new Light();
        LocalDateTime elevenPM = LocalDateTime.of(2021,04,28,23,00,00);
        aLight.turnOn();

        // When: add the light and set the house time to eleven AM
        aHome.addLight(aLight);
        aHome.setTime(elevenPM);

        // Then: the light is off
        Assert.assertFalse( aHome.getLights().get(0).isOn() );
    }


    @Test
    public void testLightsAreOffAtElevenThirtyPM() {
        // Given: a home, a light, 11.30 PM
        Home aHome = new Home();
        Light aLight = new Light();
        LocalDateTime elevenThirtyPM = LocalDateTime.of(2021,04,28,23,30,00);

        // When: add the light and set the house time to eleven AM
        aHome.addLight(aLight);
        aHome.setTime(elevenThirtyPM);

        // Then: the light is off
        Assert.assertFalse( aHome.getLights().get(0).isOn() );
    }

}
