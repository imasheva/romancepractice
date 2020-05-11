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

public class RegistrationTests extends BaseUI {

    @Test
    public void testRegistration() {

        mainPage.clickJoinButton();
        mainPage.completeFirstPartOfRegistartion();
        mainPage.completeSecondPartOfRegistration();


    }
}



