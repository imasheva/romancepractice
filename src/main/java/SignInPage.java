import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SignInPage extends BaseActions {
    String currentUrlSignIn;
    String expectedTitleSignIn;

    public SignInPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void openSignInPage() {

        driver.findElement(Locators.LINK_SIGN_IN).click();
        currentUrlSignIn = driver.getCurrentUrl();

        Assert.assertEquals(currentUrlSignIn, Data.expectedUrlSignIn);
        System.out.println(currentUrlSignIn);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

      //  String actualTitle = driver.findElement(Locators.TITLE_SIGN_IN).getText();
      //  Assert.assertEquals(Data.expectedTitleSignIn, actualTitle);
    }


    public void signIn() {

       // sendKeys("");
       // sendKeys("");
        ////button[@id='show-registration-block']   -  click


    }
}
