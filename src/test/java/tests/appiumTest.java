package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import logic.homePge;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class appiumTest {
    private AndroidDriver<MobileElement> driver;
    private homePge home;

    public appiumTest() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("platformVersion", "13");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.claudivan.taskagenda");
        caps.setCapability("appActivity", ".Activities.MainActivity");
        try {
            driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
            home = new homePge(driver);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
    @Test
    public void event(){
        // Act

        //ARRANGE
        home.add_new_event();
        home.enterEventTitle("party Event ");
        home.enterEventdescription("very fun partyyy");
        home.selectEventDate("2023-10-30");
        home.save();

        //ASSERT
        Assert.assertTrue(home.check_pending_events());
    }

    @Test
    public void updateDate(){
        // ARRANGE
        home.update();

        // ACT
        String newDate = "2023-11-15";
        home.selectEventDate(newDate);
        home.save();

        // ASSERT
        String updatedDate = home.newDate();
        Assert.assertEquals(updatedDate, "November 15, 2023");

    }
    @Test
    public void update_Task_Type(){
        //ARRANGE
        home.update();
        home.change_the_tasktype();
        home.save();
        //ACT
        String newType = home.go_to_pending_and_get_first_event_type();
        //ASSERT
        String expectedType = "Not forget";
        Assert.assertEquals(newType,expectedType);
    }
    @Test
    public void delete_event(){
        //ARRANGE
        home.delete_event();
        //ASSERT
        Assert.assertFalse(home.check_pending_events());


    }
    @Test
    public void Add_Hour(){
        // ARRANGE
        home.update();

        // ACT
        String newHour = "10"; 
        String newMinute = "30"; 
        home.setHour(newHour);
        home.setMinute(newMinute);
        home.switchToAm();
        home.save();

        // ASSERT
        String updatedTime = home.new_Time();
        Assert.assertEquals(updatedTime, "10:30 am");

    }

    }


