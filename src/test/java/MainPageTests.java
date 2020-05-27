import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

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

    @Test (priority = 2, enabled = testCase10, groups ={"admin"})

    public void checkLinksWithAssertionsTestCase10() {       //VIDEO 10 36:57

        mainPage.javaWaitSec(3);
        mainPage.navigateToLink(Locators.LINK_HOME);

        String actualTitle;
        String actualUrlPrettyWomen;
        String actualUrlPhotos;
        String actualUrlGifts;
        String actualUrlTourToUkraine;
        String actualUrlBlog;
        String actualUrlSignIn;

        List<WebElement> links = driver.findElements(Locators.TAB_OF_MAIN_PAGE);

        for (int i = 0; i < links.size(); i++) {

            String info = links.get(i).getText();
            System.out.println(info);
            links.get(i).click();
            mainPage.javaWaitSec(3);

            if (info.contains("WORK")) {
                actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();
                Assert.assertEquals(Data.expectedTitleHowWeWork, actualTitle);
            }
            if (info.contains("PRETTY WOMEN")) {

                actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();
                actualUrlPrettyWomen = driver.getCurrentUrl();

                Assert.assertEquals(Data.expectedTitlePrettyWomen, actualTitle);
                Assert.assertEquals(Data.expectedUrlPrettyWomen, actualUrlPrettyWomen);

            }
            if (info.contains("PHOTOS")) {
                actualUrlPhotos = driver.getCurrentUrl();
                Assert.assertEquals(Data.expectedUrlPhotos, actualUrlPhotos);
                if (actualUrlPhotos.contains("#")) {
                    Assert.fail("It contains restricted #");
                } else {
                    System.out.println("No special character. It is good url!");
                }
            }
            if (info.contains("GIFTS")) {
                actualUrlGifts = driver.getCurrentUrl();
                Assert.assertEquals(Data.expectedUrlGifts, actualUrlGifts);
                if (actualUrlGifts.contains("#")) {
                    Assert.fail("It contains restricted #");
                } else {
                    System.out.println("No special character. It is good url!");
                }
            }
            if (info.contains("TOUR")) {
                actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();
                actualUrlTourToUkraine = driver.getCurrentUrl();
                Assert.assertEquals(Data.expectedTitleTourToUkraine, actualTitle);
                Assert.assertEquals(Data.expectedUrlTourUkraine, actualUrlTourToUkraine);
                if (actualUrlTourToUkraine.contains("#")) {
                    Assert.fail("It contains restricted #");
                } else {
                    System.out.println("No special character. It is good url!");
                }
            }
            if (info.contains("BLOG")) {
                actualUrlBlog = driver.getCurrentUrl();
                if (actualUrlBlog.contains("#")) {
                    Assert.fail("It contains restricted #");
                } else {
                    System.out.println("No special character. It is good url!");
                }
            }
            if (info.contains("SIGN")) {
                driver.findElement(By.xpath("//div[@class='lc-content-outer']")).isDisplayed();
            }
            driver.get(Data.mainUrl);
            links = driver.findElements(Locators.TAB_OF_MAIN_PAGE);
        }
    }


    @Test (priority = 3, enabled = testCase11, groups ={"admin"})
    public void checkTabsNamesTestCase11() {                   //  HW 10 - ArrayList<String>
        mainPage.navigateToLink(Locators.LINK_HOME);
        mainPage.checkTabsNamesTest();
    }

    @Test (priority = 4, enabled = testCase12, groups ={"admin"})
    public void verifyIFrameSizeOnMainPageTestCase12() {
        mainPage.javaWaitSec(3);
        int numberOfIframes = mainPage.countIframeSize();
        Assert.assertTrue(numberOfIframes > 0, "Number is more than 0");
    }

    @Test (priority = 5, enabled = testCase13, groups ={"admin", "user"})
    public void testMainPageIFrameTestCase13() throws InterruptedException {
        mainPage.navigateToLink(Locators.LINK_HOME);
        mainPage.javaWaitSec(3);
        mainPage.testIframeOnMainPage();      //use scroll in future
    }

    @Test (priority = 6, enabled = testCase14, groups ={"admin", "user", "ie"})
    public void testBookNowTestCase14() {
        mainPage.navigateToLink(Locators.LINK_HOME);
        mainPage.verifyBookNow();
    }

    @Test (priority = 7, enabled = testCase15, groups ={"admin"})
    public void testDiscountAlertTestCase15() {
        mainPage.navigateToLink(Locators.LINK_HOME);
        mainPage.verifyDiscountAlert();
      //  Assert.assertTrue(actualString.contains(Data.mainPageDiscountAlert));
    }
   /* public void verifyDiscountAlert() {

        String actualString = driver.findElement(Locators.BOOK_NOW_TAB).getText();
        Assert.assertTrue(actualString.contains("Save 60%"));
    }
*/


    @Test (priority = 8, enabled = testCase16, groups ={"admin"})
    public void verifyRomanceAbroadHeaderTestCase16() {
        mainPage.navigateToLink(Locators.LINK_HOME);
       // mainPage.verifyHeader();
      //  public void verifyHeader() {

            WebElement header = driver.findElement(Locators.HEADER_ROMANCE_ABROAD);
            assertTrue(header.isDisplayed());
       // }
    }

    @Test (priority = 9, enabled = testCase17, groups ={"admin"})
    public void testLinksOnMainPageTestCase17() {
        mainPage.navigateToLink(Locators.LINK_HOME);
        mainPage.checkLinksOnWebPage("//a", "href"); //a  href
        mainPage.checkLinksOnWebPage("//img", "src"); //img src   //*** video 14, 21:10
    }

    @Test //  VIDEO 16 59:00
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
