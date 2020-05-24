import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class MainPageTests extends BaseUI {

    @Test
    public void checkTabs() {
        mainPage.navigateToLink(Locators.LINK_HOME);
        mainPage.javaWaitSec(3);
        mainPage.checkLinks();
    }

    @Test
    public void checkLinksWithAssertions() {       //VIDEO 10 36:57
        mainPage.javaWaitSec(3);
        mainPage.navigateToLink(Locators.LINK_HOME);
        mainPage.checkLinksAddAssertions();
    }

    @Test
    public void checkTabsNames() {                   //  HW 10 - ArrayList<String>
        mainPage.navigateToLink(Locators.LINK_HOME);
        mainPage.checkTabsNamesTest();

    }

    @Test
    public void verifyIFrameSizeOnMainPage() {
        mainPage.javaWaitSec(3);
        int numberOfIframes = mainPage.countIframeSize();
        Assert.assertTrue(numberOfIframes > 0, "Number is more than 0");
    }

    @Test
    public void testMainPageIFrame() throws InterruptedException {
        mainPage.navigateToLink(Locators.LINK_HOME);
        mainPage.javaWaitSec(3);
        mainPage.testIframeOnMainPage();      //use scroll in future
    }

    @Test
    public void testBookNow() {
        mainPage.navigateToLink(Locators.LINK_HOME);
        mainPage.verifyBookNow();
    }

    @Test
    public void testDiscountAlert() {
        mainPage.navigateToLink(Locators.LINK_HOME);
        mainPage.verifyDiscountAlert();
    }

    @Test
    public void verifyRomanceAbroadHeader() {
        mainPage.navigateToLink(Locators.LINK_HOME);
        mainPage.verifyHeader();
    }

    @Test
    public void testLinksOnMainPage() {
        mainPage.navigateToLink(Locators.LINK_HOME);
        mainPage.checkLinksOnWebPage("//a", "href"); //a  href
        mainPage.checkLinksOnWebPage("//img", "src"); //img src   //*** video 14, 21:10
    }


}
