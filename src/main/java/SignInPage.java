import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SignInPage extends BaseActions {


    public SignInPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void openSignInPage() {

        driver.findElement(Locators.LINK_SIGN_IN).click();

    }


    public void signIn() {

       // sendKeys("");
       // sendKeys("");
        ////button[@id='show-registration-block']   -  click


    }
}
