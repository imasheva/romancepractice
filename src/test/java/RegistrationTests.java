import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegistrationTests extends BaseUI {

    public static final boolean testCase2 = true;

    @Test (priority = 1, enabled = testCase2, groups ={"user", "admin"})
    public void testRegistration() {
        signInPage.openSignInPage();
        mainPage.clickJoinButton();
        mainPage.completeFirstPartOfRegistartion();
        //can I use wait below or javaWaitSec(3);?
        //What is better?
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        mainPage.completeSecondPartOfRegistration();


    }
}



