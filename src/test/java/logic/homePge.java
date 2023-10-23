package logic;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.NoSuchElementException;

public class homePge extends basePage {
    private MobileElement addButton;
    private MobileElement calendar;
    private MobileElement pending_events;
    private MobileElement today;
    private MobileElement eventTitle;
    private MobileElement eventdescription;
    private MobileElement saveButton;
    private MobileElement dateField;
    private MobileElement dateElement;
    private MobileElement OK;
    private MobileElement hourValue;
    private MobileElement minuteValue;
    private MobileElement AmTap;
    private MobileElement pends;

    public homePge(MobileDriver driver) {
        super(driver);
    }

    public void add_new_event() {
        addButton = (MobileElement) driver.findElement(Locators.ADD_EVENT);
        addButton.click();
        today = (MobileElement) waitTillVisible(driver, 10, Locators.TODAY);
        today.click();

    }

    public void enterEventTitle(String title) {
        eventTitle = (MobileElement) driver.findElement(Locators.EVENT_NAME);
        eventTitle.sendKeys(title);
    }

    public void enterEventdescription(String description) {
        eventdescription = (MobileElement) driver.findElement(Locators.EVENT_NAME);
        eventdescription.sendKeys(description);
    }

    public void save() {
        saveButton = (MobileElement) driver.findElement(Locators.SAVE);
        saveButton.click();
    }

    public void selectEventDate(String date) {
        dateField = (MobileElement) driver.findElement(Locators.DATE);
        dateField.click();
            dateElement = (MobileElement) waitTillVisible(driver, 10, By.id("com.claudivan.taskagenda:id/btData"));
            dateElement.click();

        OK = (MobileElement) driver.findElement(Locators.confirmDate);
        OK.click();
    }

    public String newDate(){

            dateField = (MobileElement) driver.findElement(Locators.DATE);
            dateField.click();
            String Date = waitTillVisible(driver, 10, By.id("com.claudivan.taskagenda:id/btData")).getText();

        return Date;
    }


    public void setHour(String hour) {
        hourValue = (MobileElement) driver.findElement(Locators.HOUR);
        hourValue.sendKeys(hour);
    }

    public void setMinute(String minutes) {
        minuteValue = (MobileElement) driver.findElement(Locators.MINUTE);
        minuteValue.sendKeys(minutes);
    }

    public void switchToAm() {
        AmTap = (MobileElement) driver.findElement(Locators.AMPM);
        AmTap.click();
        waitTillClickable(driver, 10, Locators.AM);
    }
    public String new_Time(){
        String Time= driver.findElement(By.id("com.claudivan.taskagenda:id/tvHora")).getText();
        return Time;
    }


    public void go_to_calender() {
        calendar = (MobileElement) driver.findElement(Locators.CALENDAR);
        calendar.click();
    }

    public void delete_event() {
        pending_events = (MobileElement) driver.findElement(Locators.PENDING_EVENTS);
        pending_events.click();

        MobileElement list = (MobileElement) waitTillVisible(driver, 10, By.id("com.claudivan.taskagenda:id/lvListaEventos"));


        if (list.isDisplayed()) {

            MobileElement firstEvent = (MobileElement) list.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.FrameLayout[1]/android.widget.RelativeLayout"));
            firstEvent.click();

            MobileElement deletebutton = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@text=\"DELETE\"]"));
            deletebutton.click();

            MobileElement okbutton = (MobileElement) waitTillVisible(driver, 10, By.id("android:id/button1"));
            okbutton.click();
        }
    }

    public void update() {

        pending_events = (MobileElement) driver.findElement(Locators.PENDING_EVENTS);
        pending_events.click();

        MobileElement list = (MobileElement) waitTillVisible(driver, 10, By.id("com.claudivan.taskagenda:id/lvListaEventos"));


        if (list.isDisplayed()) {

            MobileElement firstEvent = (MobileElement) list.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.FrameLayout[1]/android.widget.RelativeLayout"));
            firstEvent.click();

            MobileElement update = (MobileElement) driver.findElement(By.id("com.claudivan.taskagenda:id/item_editar"));
            update.click();
        }
    }

    public void change_the_tasktype() {
        MobileElement type = (MobileElement) driver.findElement(Locators.TASK_TYPE);
        type.click();

        MobileElement NotForget = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.RelativeLayout[3]/android.widget.TextView"));
        NotForget.click();


    }

    public boolean check_pending_events() {
        pending_events = (MobileElement) driver.findElement(Locators.PENDING_EVENTS);
        pending_events.click();

        //locate the page
        MobileElement list = (MobileElement) waitTillVisible(driver, 10, By.id("com.claudivan.taskagenda:id/lvListaEventos"));
        //check if the page contain any events
        if (list.isDisplayed()) {
            return true;
        }
        return false;
    }

    public String go_to_pending_and_get_first_event_type() {
        pending_events = (MobileElement) driver.findElement(Locators.PENDING_EVENTS);
        pending_events.click();

        MobileElement list = (MobileElement) waitTillVisible(driver, 10, By.id("com.claudivan.taskagenda:id/lvListaEventos"));

        String type = null; // Default value in case the list is not displayed

        if (list.isDisplayed()) {
            MobileElement firstEvent = (MobileElement) list.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.FrameLayout[1]/android.widget.RelativeLayout"));
            firstEvent.click();

            type = driver.findElement(By.id("com.claudivan.taskagenda:id/tvTipo")).getText();
        }

        return type;
    }
}

