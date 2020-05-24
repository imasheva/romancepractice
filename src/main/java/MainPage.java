import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class MainPage extends BaseActions {

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    String currentUrlBlog;
    String currentUrlGifts;
    String currentUrlHowWeWork;
    String currentUrlMedia;
    String currentUrlSignIn;
    String currentUrlTourUkraine;
    String currentUrlSearch;
    String currentUrlContactUs;

    public void clickJoinButton() {
        driver.findElement(Locators.BUTTON_REGISTRATION).click();
    }


    public void completeFirstPartOfRegistartion() {

        // HOW TO OPTIMIZE CODE BELOW?

        driver.findElement(Locators.TEXT_FIELD_EMAIL).sendKeys(Data.email);

        String strEmail = driver.findElement(Locators.TEXT_FIELD_EMAIL).getAttribute("value");
        System.out.println("Email: " + strEmail);

        driver.findElement(Locators.TEXT_FIELD_PASSWORD).sendKeys(Data.password);

        String strPassword = driver.findElement(Locators.TEXT_FIELD_PASSWORD).getAttribute("value");
        System.out.println("Password: " + strPassword);


        WebElement btnNext = driver.findElement(Locators.BUTTON_NEXT);
        if (btnNext.isDisplayed() && btnNext.isEnabled()) {
            btnNext.click();
            System.out.println("Button next  is displyed, enabled and clicked");
        }

    }

    public void completeSecondPartOfRegistration() {

        //OLEKSII QUESTION BELOW:
        /*NE POLUCHILOS to use generator: add dependency + method -> DOBAVILA / shows error
        driver.findElement(Locators.TEXT_FIELD_NICKNAME).sendKeys(generateNewNumber(Data.nickname));*/

        driver.findElement(Locators.TEXT_FIELD_NICKNAME).sendKeys(Data.nickname);
        String strNickName = driver.findElement(Locators.TEXT_FIELD_NICKNAME).getAttribute("value");
        System.out.println("Nickname: " + strNickName);

        driver.findElement(Locators.LIST_DAYS).click();
        clickValueOfLists(Locators.LIST_VALUE_DAY, Data.dayOfBirth);
        System.out.println("Day selected: " + Data.dayOfBirth);

        driver.findElement(Locators.LIST_MONTHS).click();
        clickValueOfLists(Locators.LIST_VALUE_MONTH, Data.monthOfBirth);
        System.out.println("Month selected: " + Data.monthOfBirth);


        driver.findElement(Locators.LIST_YEARS).click();
        clickValueOfLists(Locators.LIST_VALUE_YEAR, Data.yearOfBirth);
        System.out.println("Year selected: " + Data.yearOfBirth);


        WebElement checkbox = driver.findElement((Locators.CHECKBOX_CONFIRMATION));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }

        driver.findElement(Locators.TEXT_FIELD_PHONE).sendKeys(Data.phone);
        String phoneNum = driver.findElement(Locators.TEXT_FIELD_PHONE).getAttribute("value");
        System.out.println("Phone number: " + phoneNum);

        // HOW TO VERIFY LOCATION TEXT DISPLAYED AFTER ENTERING NUMBER ???
        //DIDN'T WORK FOR ME ((
        WebElement location = driver.findElement(Locators.LOCATION_INPUT);
        String title = location.getAttribute("title");
        System.out.println(location.getAttribute("title"));

    }

    public void testIframeOnMainPage() throws InterruptedException {

        WebElement ele = driver.findElement(Locators.IFRAME);
        ajaxScroll(ele);
        driver.switchTo().frame(ele);
        driver.findElement(Locators.YOUTUBE_PLAY_BUTTON).click();

    }


    public void checkLinks() {

        List<WebElement> list = driver.findElements(By.xpath("//ul[@class='navbar-nav']//li"));
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
            System.out.println(i + " ArrayList Text : " + s);
            i++;
        }
    }

    public void checkTabsNamesTest() {

        List<WebElement> listTabs = driver.findElements(By.xpath("//ul[@class='navbar-nav']//li"));

        List<String> strings = new ArrayList<String>();
        for (WebElement tab : listTabs) {
            strings.add(tab.getText());
        }
        System.out.println("Print all the tabs name" + strings); // How to print in ordered list

    }

    public void checkLinksAddAssertions() {
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

            if (info.contains("WORK")) {
                actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();
                Assert.assertEquals(Data.expectedTitleHowWeWork, actualTitle);
            }
            if (info.contains("PRETTY WOMEN")) {

                actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();
                actualUrlPrettyWomen = driver.getCurrentUrl();

                Assert.assertEquals(Data.expectedTitlePrettyWomen, actualTitle);
                Assert.assertEquals(Data.expectedUrlPrettyWomen, actualUrlPrettyWomen);
                driver.findElement(By.xpath("//a[@class='g-pic-border g-rounded']")).isDisplayed();

                if (actualUrlPrettyWomen.contains("#")) {
                    Assert.fail("It contains restricted #");
                } else {
                    System.out.println("No special character. It is good url!");
                }

            }
            if (info.contains("PHOTOS")) {
                actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();
                actualUrlPhotos = driver.getCurrentUrl();
                Assert.assertEquals(Data.expectedTitlePhotos, actualTitle);
                Assert.assertEquals(Data.expectedUrlPhotos, actualUrlPhotos);
                driver.findElement(By.xpath("//div[@class='g-users-gallery__content']")).isDisplayed();

                if (actualUrlPhotos.contains("#")) {
                    Assert.fail("It contains restricted #");
                } else {
                    System.out.println("No special character. It is good url!");
                }
            }
            if (info.contains("GIFTS")) {
                actualUrlGifts = driver.getCurrentUrl();
                Assert.assertEquals(Data.expectedUrlGifts, actualUrlGifts);
                driver.findElement(By.xpath("//div[@class='g-users-gallery__photo ']")).isDisplayed();
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
                driver.findElement(By.xpath("//div[@class='store-content']")).isDisplayed();
                if (actualUrlTourToUkraine.contains("#")) {
                    Assert.fail("It contains restricted #");
                } else {
                    System.out.println("No special character. It is good url!");
                }
            }
            if (info.contains("BLOG")) {
                actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();
                actualUrlBlog = driver.getCurrentUrl();
                Assert.assertEquals(Data.expectedTitleBlog, actualTitle);
                Assert.assertEquals(Data.expectedUrlBlog, actualUrlBlog);
                driver.findElement(By.xpath("//div[@class='info-content-block wysiwyg']")).isDisplayed();
                if (actualUrlBlog.contains("#")) {
                    Assert.fail("It contains restricted #");
                } else {
                    System.out.println("No special character. It is good url!");
                }
            }
            if (info.contains("SIGN")) {
                //   actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();   //doesn't find
                actualUrlSignIn = driver.getCurrentUrl();
                //  Assert.assertEquals(Data.expectedTitleSignIn, actualTitle);
                //   Assert.assertEquals(Data.expectedUrlSignIn, actualUrlSignIn);
                driver.findElement(By.xpath("//div[@class='lc-content-outer']")).isDisplayed();
            }
            driver.get(Data.mainUrl);
            links = driver.findElements(Locators.TAB_OF_MAIN_PAGE);
        }
    }

    public int countIframeSize() {
       int size = driver.findElements(By.xpath("//iframe")).size();
        System.out.println(size + " " + "iFrame number");
        return size;
    }

    public void verifyBookNow() {
        WebElement bookNow = (driver.findElement(Locators.BOOK_NOW_TAB));
        assertTrue(bookNow.isDisplayed());
        bookNow.click();
    }

    public void verifyDiscountAlert() {

        String actualString = driver.findElement(Locators.BOOK_NOW_TAB).getText();
        Assert.assertTrue(actualString.contains("Save 60%"));
    }

    public void verifyHeader() {

        WebElement header = driver.findElement(Locators.HEADER_ROMANCE_ABROAD);
        assertTrue(header.isDisplayed());
    }


}

