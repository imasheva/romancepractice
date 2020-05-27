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

   // public static final boolean testCase2 = true; in case add more

    @Test
    public void testRegistrationTestCase2() {
        signInPage.openSignInPage();
        mainPage.clickJoinButton();

        mainPage.completeFirstPartOfRegistration(Data.email, Data.password);

        mainPage.completeSecondPartOfRegistration(mainPage.generateNewNumber(Data.nickname, 5),Data.phone,
                Data.month, Data.day, Data.year, Data.city, Data.location);

    }


}



