import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest  extends BaseUI{
    String currentUrlSignIn;
    String expectedTitleSignIn;
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

        //  String actualTitle = driver.findElement(Locators.TITLE_SIGN_IN).getText();
        //  Assert.assertEquals(Data.expectedTitleSignIn, actualTitle);
        signInPage.signIn();

    }
}
