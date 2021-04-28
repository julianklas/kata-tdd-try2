import com.kata.sls.domain.Home;
import com.kata.sls.domain.Light;
import com.kata.sls.domain.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

// Lights turns on automatically every day at 8 AM and goes off at 11 PM
// The user can cancel the scheduled action
public class UserTests {

    @Test
    public void testUserCanExist() {
        // Given: a user
        User cris = new User();
        // When: I create the user
        // Then: it's there
        Assert.assertNotNull(cris);
    }

    @Test
    public void testUserCanCancelEightAmActions() {
        // Given: a user, a home, a light, 7AM and 9AM
        User cris = new User();
        Home aHome = new Home();
        Light aLight = new Light();
        LocalDateTime sevenAM = LocalDateTime.of(2020,4,28,7,0,0);
        LocalDateTime nineAM = LocalDateTime.of(2020,4,28,9,0,0);
        aHome.addLight(aLight);

        // When: the user cancels today's actions
        aHome.setTime(sevenAM);

        cris.cancelTodaySchedule(aHome, sevenAM);

        aHome.setTime(nineAM);

        // Then: lights are not on
        Assert.assertFalse(aHome.getLights().get(0).isOn());
    }

    @Test
    public void testUserCanCancelElevenPmActions() {
        // Given: a user, a home, a light, 7AM and 9AM
        User cris = new User();
        Home aHome = new Home();
        Light aLight = new Light();
        LocalDateTime tenPM = LocalDateTime.of(2020,4,28,22,0,0);
        LocalDateTime elevenThirtyPM = LocalDateTime.of(2020,4,28,23,30,0);
        aHome.addLight(aLight);
        aHome.setTime(tenPM);

        // When: the user cancels today's actions
        cris.cancelTodaySchedule(aHome, tenPM);

        aHome.setTime(elevenThirtyPM);

        // Then: lights are on
        Assert.assertTrue(aHome.getLights().get(0).isOn());
    }

    @Test
    public void testCancelledActionsAreErasedTomorrow() {
        // Given: a user, a home, a light, 7AM and 9AM
        User cris = new User();
        Home aHome = new Home();
        Light aLight = new Light();
        LocalDateTime sevenAM = LocalDateTime.of(2020,4,28,7,0,0);
        LocalDateTime nineAM = LocalDateTime.of(2020,4,28,9,0,0);
        LocalDateTime tomorrowNineAM = LocalDateTime.of(2020,4,29,9,0,0);
        aHome.addLight(aLight);

        // When: the user cancels today's actions
        aHome.setTime(sevenAM);

        cris.cancelTodaySchedule(aHome, sevenAM);

        aHome.setTime(nineAM);

        // Then: lights are not on
        Assert.assertFalse(aHome.getLights().get(0).isOn());

        // When: day has changed
        aHome.setTime(tomorrowNineAM);

        // Then: lights are on
        Assert.assertTrue(aHome.getLights().get(0).isOn());
    }
}
