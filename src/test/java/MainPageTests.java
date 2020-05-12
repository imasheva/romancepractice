import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MainPageTests extends BaseUI{


    @Test
    public void testMainPageIFrame() throws InterruptedException {

        //scroll didn't work for me
        mainPage.testIframeOnMainPage();
        //failed
    }



}
