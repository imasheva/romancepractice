import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignInTest extends BaseUI {
    String currentUrlSignIn;
    String currentTitleSignIn;

    @Test
    public void testSignIn() {
        signInPage.openSignInPage();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        signInPage.signIn();


    }
}
