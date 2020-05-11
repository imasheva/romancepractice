import org.testng.annotations.Test;

public class SignInTest  extends BaseUI{

    @Test
    public void testLogin(){

        signInPage.openSignInPage();
        signInPage.signIn();

    }
}
