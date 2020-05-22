import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MainPageTests extends BaseUI {



    @Test
    public void checkTabs() {
        mainPage.checkLinks();

    }

    @Test //VIDEO 10 -36:57
    public void checkLinksWithAssertions() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        mainPage.checkLinksAddAssertions();


    }

    //  HW 10 - ArrayList<String>
    @Test
    public void checkTabsNames() {
        mainPage.checkTabsNamesTest();

    }

    @Test
    public void verifyIFrameSizeOnMainPage() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        int numberOfIframes = mainPage.countIframeSize();
        Assert.assertTrue(numberOfIframes > 0, "Number is more than 0");
    }
    @Test
    public void testMainPageIFrame() throws InterruptedException {
        //use scroll in future
        mainPage.testIframeOnMainPage();
    }
    @Test
    public void testBookNow(){
        mainPage.navigateToLinkHome();
        mainPage.verifyBookNow();
    }
    @Test
    public void testDiscountAlert(){
        mainPage.navigateToLinkHome();
        mainPage.verifyDiscountAlert();
    }




}
