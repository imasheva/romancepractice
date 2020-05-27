import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ContactsUsPage extends BaseActions {
    public ContactsUsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void openContactUsPage() {

        navigateToLinkPage(Locators.LINK_PRETTY_WOMEN);

        ajaxClick(Locators.CONTACT_US_LINK);

        // 1. Vopros chto luchshe to use?
        // javaWaitSec(3);         ili      // driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        // 2. If I use one of above the anjax click, is it double wait?
        /*
         public void ajaxClick(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
        ajaxClick(driver.findElement(by));
    }
         */

    }

    public void selectReasonDropDownContactUs() {

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement reason_DropDown = driver.findElement(Locators.DROP_DOWN_REASON_CONTACT_US);
        getDropDownListByText(reason_DropDown, Data.reason_ContactUs);

    }

    public void fillOutContactAdministratorForm(String yourname, String youremail, String subject, String message) {


        driver.findElement(Locators.TEXT_FIELD_YOUR_NAME).sendKeys(yourname);
        driver.findElement(Locators.TEXT_FIELD_YOUR_EMAIL).sendKeys(youremail);
        driver.findElement(Locators.TEXT_FIELD_SUBJECT).sendKeys(subject);
        driver.findElement(Locators.TEXT_FIELD_MESSAGE).sendKeys(message);

        driver.findElement(Locators.BUTTON_SEND_CONTACT_US_PAGE).click();

        //HOW TO DO SECURITY CODE? Maybe in upcoming lesson
    }


    public void verifySizeOfDropDownList() {
    }
}
