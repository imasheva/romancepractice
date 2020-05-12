import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class SignInPage extends BaseActions {


    public SignInPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void openSignInPage() {

        driver.findElement(Locators.LINK_SIGN_IN).click();

    }

    public void login() {

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(Locators.EMAIL_LOGIN).sendKeys(Data.emailSignIn);
        driver.findElement(Locators.PASSWORD_LOGIN).sendKeys(Data.passwordSignIn);
        driver.findElement(Locators.BUTTON_LOGIN).click();




    }
}
