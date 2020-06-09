package com.romanceabroad.ui;
import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import static org.testng.Assert.assertTrue;



@Listeners(VideoListener.class)

public class MainPageTests extends BaseUI {

    public static final boolean testCase10 = true;
    public static final boolean testCase11 = true;
    public static final boolean testCase12 = true;
    public static final boolean testCase13 = true;
    public static final boolean testCase14 = true;
    public static final boolean testCase15 = true;
    public static final boolean testCase16 = true;
    public static final boolean testCase17 = true;
    public static final boolean testCase18 = true;
    public static final boolean testCase19 = true;  //SMOKE TEST

    String actualTitle;
    String actualUrlPrettyWomen;
    String actualUrlPhotos;
    String actualUrlGifts;
    String actualUrlTourToUkraine;
    String actualUrlBlog;
    String actualUrlSignIn;
    String actualStringDiscount;
    WebElement header;

    @Video(name = "MainPage Tests")
    @Test(priority = 1, enabled = testCase10, groups = {"admin"})

    public void checkTabsTestCase10() {

        mainPage.navigateToLink(Locators.LINK_HOME);
        mainPage.javaWaitSec(3);

        List<WebElement> list = mainPage.collectLinks();
        System.out.println("Size of the the tabs: " + list.size());

        ArrayList<String> linkText = new ArrayList<String>();

        for (WebElement ele : list) {
            try {
                linkText.add(ele.getText());
            } catch (Exception e) {
                //TODO: HANDLE EXCEPTION
            }
        }
        System.out.println("Size of the ArrayList " + linkText.size());
        int i = 1;
        for (String s : linkText) {
            System.out.println(i + " Name : " + s);
            i++;
        }
    }


    @Test(priority = 2, enabled = testCase11, groups = {"admin"})

    public void checkLinksWithAssertionsTestCase11() {       //VIDEO 10 36:57

        mainPage.javaWaitSec(3);
        mainPage.navigateToLink(Locators.LINK_HOME);
        mainPage.collectLinksWithAssertions();
    }

    //  HW 10 - ArrayList<String>
    // print in ordered list

    @Test(priority = 3, enabled = testCase12, groups = {"admin"})
    public void checkTabsNamesTestCase12() {
        mainPage.navigateToLink(Locators.LINK_HOME);

        mainPage.checkTabsNamesTest();

        List<WebElement> listTabs = mainPage.collectLinks();

        List<String> strings = new ArrayList<String>();

        for (WebElement tab : listTabs) {
            strings.add(tab.getText());
        }
        System.out.println("Print all the tabs name" + strings);

    }


    @Test(priority = 4, enabled = testCase13, groups = {"admin"})
    public void verifyIFrameSizeOnMainPageTestCase13() {
        mainPage.javaWaitSec(3);
        int numberOfIframes = mainPage.countIframeSize();
        Assert.assertTrue(numberOfIframes > 0, "Number is more than 0");
    }

    @Test(priority = 5, enabled = testCase14, groups = {"admin", "user"})
    public void testMainPageIFrameTestCase14() throws InterruptedException {
        mainPage.navigateToLink(Locators.LINK_HOME);
        mainPage.javaWaitSec(3);
        mainPage.testIframeOnMainPage();      //use scroll in future
    }

    @Test(priority = 6, enabled = testCase15, groups = {"admin", "user", "ie"})
    public void testBookNowTestCase15() {
        mainPage.navigateToLink(Locators.LINK_HOME);
        mainPage.verifyBookNow();
    }

    @Test(priority = 7, enabled = testCase16, groups = {"admin"})
    public void testDiscountAlertTestCase16() {
        mainPage.navigateToLink(Locators.LINK_HOME);
        actualStringDiscount = mainPage.verifyDiscountAlert();
        Assert.assertTrue(actualStringDiscount.contains(Data.mainPageDiscountAlert));
    }


    @Test(priority = 8, enabled = testCase17, groups = {"admin"})
    public void verifyRomanceAbroadHeaderTestCase17() {
        mainPage.navigateToLink(Locators.LINK_HOME);
        header = mainPage.verifyHeader();
        assertTrue(header.isDisplayed());

    }
    //Video 14, 21:10
    @Test(priority = 9, enabled = testCase18, groups = {"admin"})
    public void testLinksOnMainPageTestCase18() {
        mainPage.navigateToLink(Locators.LINK_HOME);
        mainPage.checkLinksOnWebPage("//a", "href");
        mainPage.checkLinksOnWebPage("//img", "src");
    }

    @Test(priority = 9, enabled = testCase19, groups = {"admin"})
    //  VIDEO 16 59:00
    public void smokeTestMainPageTestCase19() {

        List<WebElement> mainTabs = mainPage.collectLinks(); //tabs
        System.out.println("Size of tabs: " + mainTabs);
        for (int i = 0; i < mainTabs.size(); i++) {
            mainTabs.get(i).click();
            // then we have to return after click
            driver.get(Data.mainUrl);
            //then collect again the list inside of loop
            mainTabs = mainPage.collectLinks(); //tabs


        }


    }




}
