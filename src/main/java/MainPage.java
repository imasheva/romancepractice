import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainPage extends BaseActions {

    //CONSTRUCTOR
    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickJoinButton() {
        driver.findElement(Locators.BUTTON_REGISTRATION).click();
    }

    // MODAL WINDOW

    public void completeFirstPartOfRegistartion() {
        driver.findElement(Locators.TEXT_FIELD_EMAIL).sendKeys(Data.email);
        driver.findElement(Locators.TEXT_FIELD_PASSWORD).sendKeys(Data.password);
        driver.findElement(Locators.BUTTON_NEXT).click();
    }


    public void completeSecondPartOfRegistration()  {

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        /*NE POLUCHILOS to use generator: add dependency + method / shows error
        driver.findElement(Locators.TEXT_FIELD_NICKNAME).sendKeys(generateNewNumber(Data.nickname));*/

        driver.findElement(Locators.TEXT_FIELD_NICKNAME).sendKeys(Data.nickname);

        //Bootstrap dropdown *** How to create method for Base Actions?

        List<WebElement> options = driver.findElements(Locators.DAY_LIST_DROPDOWN);
        System.out.println(options.size());
        for (WebElement ele : options) {
            String value = ele.getText();
            if (value.equalsIgnoreCase(Data.dayOfBirthString)) {
                ele.click();
                break;
            }
        }

        //Bootstrap dropdown     *** How to create method for Base Actions?
        List<WebElement> monthList = driver.findElements(Locators.MONTH_LIST_DROPDOWN);

        System.out.println("month list size: " + monthList.size());

        for (int i = 0; i < monthList.size(); i++) {

            if (monthList.get(i).getText().equalsIgnoreCase(Data.monthOfBirth)) {
                monthList.get(i).click();
                break;
            }
        }
        List<WebElement> yearList = driver.findElements(Locators.YEAR_LIST_DROPDOWN);

        System.out.println("year list size: " + yearList.size()); //just to check for myself

        for (int i = 0; i < yearList.size(); i++) {

            if (yearList.get(i).getText().contains(Data.yearOfBirth)) {
                yearList.get(i).click();
                break;
            }
        }

        driver.findElement(Locators.TEXT_FIELD_PHONE).sendKeys(Data.phone);

      //  WebElement location = driver.findElement(Locators.LOCATION_INPUT);
      //  location.clear(); - ne poluchaetsya to use clear method
      //  location.sendKeys(Data.location);

        WebElement checkBoxConfirmation = driver.findElement(Locators.CHECKBOX_CONFIRMATION);
        if (!driver.findElement(Locators.CHECKBOX_CONFIRMATION).isSelected()) {
            checkBoxConfirmation.click();

        }
    }


    //Oleksii's method

    public void testIframeOnMainPage() throws InterruptedException {

        //do I need open page? method and assertions?
        //Add waits
        //Add title assertion
        //Add press tabs Loop
        //Add scroll

       // Video 7 55:31

        WebElement ele = driver.findElement (Locators.IFRAME);
        ajaxScroll(ele);
        driver.switchTo().frame(ele);
        //Doesn't find button
        driver.findElement(By.xpath("//a[@class='btn btn-primary btn-xl js-scroll-trigger']")).click();

    }


}



