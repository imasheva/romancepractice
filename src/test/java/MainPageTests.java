import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.List;
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
    public void checkTabsTestCase9() {
        mainPage.navigateToLink(Locators.LINK_HOME);
        mainPage.javaWaitSec(3);
        mainPage.checkLinks();
    }

    @Test (priority = 1, enabled = testCase10, groups ={"admin"})
    public void checkLinksWithAssertionsTestCase10() {       //VIDEO 10 36:57
        mainPage.javaWaitSec(3);
        mainPage.navigateToLink(Locators.LINK_HOME);
        mainPage.checkLinksAddAssertions();
    }

    @Test (priority = 1, enabled = testCase11, groups ={"admin"})
    public void checkTabsNamesTestCase11() {                   //  HW 10 - ArrayList<String>
        mainPage.navigateToLink(Locators.LINK_HOME);
        mainPage.checkTabsNamesTest();
    }

    @Test (priority = 1, enabled = testCase12, groups ={"admin"})
    public void verifyIFrameSizeOnMainPageTestCase12() {
        mainPage.javaWaitSec(3);
        int numberOfIframes = mainPage.countIframeSize();
        Assert.assertTrue(numberOfIframes > 0, "Number is more than 0");
    }

    @Test (priority = 1, enabled = testCase13, groups ={"admin", "user"})
    public void testMainPageIFrameTestCase13() throws InterruptedException {
        mainPage.navigateToLink(Locators.LINK_HOME);
        mainPage.javaWaitSec(3);
        mainPage.testIframeOnMainPage();      //use scroll in future
    }

    @Test (priority = 1, enabled = testCase14, groups ={"admin", "user"})
    public void testBookNowTestCase14() {
        mainPage.navigateToLink(Locators.LINK_HOME);
        mainPage.verifyBookNow();
    }

    @Test (priority = 1, enabled = testCase15, groups ={"admin"})
    public void testDiscountAlertTestCase15() {
        mainPage.navigateToLink(Locators.LINK_HOME);
        mainPage.verifyDiscountAlert();
    }

    @Test (priority = 1, enabled = testCase16, groups ={"admin"})
    public void verifyRomanceAbroadHeaderTestCase16() {
        mainPage.navigateToLink(Locators.LINK_HOME);
        mainPage.verifyHeader();
    }

    @Test (priority = 1, enabled = testCase17, groups ={"admin"})
    public void testLinksOnMainPageTestCase17() {
        mainPage.navigateToLink(Locators.LINK_HOME);
        mainPage.checkLinksOnWebPage("//a", "href"); //a  href
        mainPage.checkLinksOnWebPage("//img", "src"); //img src   //*** video 14, 21:10
    }

    @Test // VIDEO 16   59:00
    public void smokeTestMainPage(){

        List<WebElement> mainTabs = driver.findElements(Locators.TAB_OF_MAIN_PAGE);
        System.out.println("Size of tabs: " + mainTabs);

        for (int i=0; i<mainTabs.size(); i++){
            mainTabs.get(i).click();

            // then we have to return after click
            driver.get(Data.mainUrl);

            //then collect again the list inside of loop
            mainTabs = driver.findElements(Locators.TAB_OF_MAIN_PAGE);


        }


    }


}
