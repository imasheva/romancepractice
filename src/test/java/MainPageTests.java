import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class MainPageTests extends BaseUI {

    public static final boolean testCase9 = true;
    public static final boolean testCase10 = true;
    public static final boolean testCase11 = true;
    public static final boolean testCase12 = true;
    public static final boolean testCase13 = true;
    public static final boolean testCase14 = true;
    public static final boolean testCase15 = true;
    public static final boolean testCase16 = true;
    public static final boolean testCase17 = true;

    @Test (priority = 1, enabled = testCase9, groups ={"admin"})
    public void checkTabs() {
        mainPage.navigateToLink(Locators.LINK_HOME);
        mainPage.javaWaitSec(3);
        mainPage.checkLinks();
    }

    @Test (priority = 1, enabled = testCase10, groups ={"admin"})
    public void checkLinksWithAssertions() {       //VIDEO 10 36:57
        mainPage.javaWaitSec(3);
        mainPage.navigateToLink(Locators.LINK_HOME);
        mainPage.checkLinksAddAssertions();
    }

    @Test (priority = 1, enabled = testCase11, groups ={"admin"})
    public void checkTabsNames() {                   //  HW 10 - ArrayList<String>
        mainPage.navigateToLink(Locators.LINK_HOME);
        mainPage.checkTabsNamesTest();
    }

    @Test (priority = 1, enabled = testCase12, groups ={"admin"})
    public void verifyIFrameSizeOnMainPage() {
        mainPage.javaWaitSec(3);
        int numberOfIframes = mainPage.countIframeSize();
        Assert.assertTrue(numberOfIframes > 0, "Number is more than 0");
    }

    @Test (priority = 1, enabled = testCase13, groups ={"admin", "user"})
    public void testMainPageIFrame() throws InterruptedException {
        mainPage.navigateToLink(Locators.LINK_HOME);
        mainPage.javaWaitSec(3);
        mainPage.testIframeOnMainPage();      //use scroll in future
    }

    @Test (priority = 1, enabled = testCase14, groups ={"admin", "user"})
    public void testBookNow() {
        mainPage.navigateToLink(Locators.LINK_HOME);
        mainPage.verifyBookNow();
    }

    @Test (priority = 1, enabled = testCase15, groups ={"admin"})
    public void testDiscountAlert() {
        mainPage.navigateToLink(Locators.LINK_HOME);
        mainPage.verifyDiscountAlert();
    }

    @Test (priority = 1, enabled = testCase16, groups ={"admin"})
    public void verifyRomanceAbroadHeader() {
        mainPage.navigateToLink(Locators.LINK_HOME);
        mainPage.verifyHeader();
    }

    @Test (priority = 1, enabled = testCase17, groups ={"admin"})
    public void testLinksOnMainPage() {
        mainPage.navigateToLink(Locators.LINK_HOME);
        mainPage.checkLinksOnWebPage("//a", "href"); //a  href
        mainPage.checkLinksOnWebPage("//img", "src"); //img src   //*** video 14, 21:10
    }


}
