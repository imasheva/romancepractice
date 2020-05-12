import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest  extends BaseUI{
    String currentUrlSignIn;
    String currentTitleSignIn;

    @Test
    public void testLogin(){

        signInPage.openSignInPage();

        currentUrlSignIn = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlSignIn, Data.expectedUrlSignIn);

        System.out.println(currentUrlSignIn);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

          String actualTitle = driver.findElement(Locators.TITLE_SIGN_IN).getText();

        //   QUESTION: THIS ASSERT IS KEEP FAILING
         Assert.assertEquals(Data.expectedTitleSignIn, actualTitle);

        signInPage.login(); //LOGIN as NOT REGISTERED USER  kak togda pravilno test nazvat?

       // Assert.assertTrue(driver.findElement(By.xpath()))

    }
}
