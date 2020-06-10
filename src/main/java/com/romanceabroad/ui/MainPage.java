package com.romanceabroad.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
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
    String actualTitle;
    String actualUrlPrettyWomen;
    String actualUrlPhotos;
    String actualUrlGifts;
    String actualUrlTourToUkraine;
    String actualUrlBlog;
    String actualUrlSignIn;
    String actualStringDiscount;
    WebElement header;

    public void clickJoinButton() {
     //   Reports.log("Wait Join button");
     //   wait.until(ExpectedConditions.elementToBeClickable(Locators.BUTTON_REGISTRATION));

        Reports.log("Click Join button");
        ajaxClick(Locators.BUTTON_REGISTRATION);
       // driver.findElement(Locators.BUTTON_REGISTRATION).click();
    }


    public void completeFirstPartOfRegistration(String email, String password) {
        Reports.log("Wait email text field");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Reports.log("Type email in text field" + email);
        driver.findElement(Locators.TEXT_FIELD_EMAIL).sendKeys(email);

        Reports.log("Wait password text field");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Locators.TEXT_FIELD_PASSWORD)));
        Reports.log("Type password in text field" + password);
        driver.findElement(Locators.TEXT_FIELD_PASSWORD).sendKeys(password);
    }


    public void clickNextButton() {

        Reports.log("Wait Next button");
        wait.until(ExpectedConditions.elementToBeClickable(Locators.BUTTON_NEXT_REGISTRATION));
        Reports.log("Click Next button");
        driver.findElement(Locators.BUTTON_NEXT_REGISTRATION).click();

    }

    public void completeSecondPartOfRegistration(String nickname, String phone, String month, String day,
                                                 String year, String city, String location) {

        Reports.log("Wait Nickname textfield");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        Reports.log("Type nickname: " + nickname);
        driver.findElement(Locators.TEXT_FIELD_NICKNAME).sendKeys(nickname);

        Reports.log("Click list of days");
        driver.findElement(Locators.LIST_DAYS).click();

        Reports.log("Select specific day: " + day);
        clickValueOfLists(Locators.LIST_VALUE_DAY, day);

        Reports.log("Click list of months");
        driver.findElement(Locators.LIST_MONTHS).click();

        Reports.log("Select specific month: " + month);
        clickValueOfLists(Locators.LIST_VALUE_MONTH, month);

        Reports.log("Click specific year: " + month);
        driver.findElement(Locators.LIST_YEARS).click();

        Reports.log("Select specific year: " + year);
        clickValueOfLists(Locators.LIST_VALUE_YEAR, year);

        Reports.log("Type phone number: " + phone);
        driver.findElement(Locators.TEXT_FIELD_PHONE).sendKeys(phone);

        Reports.log("Click confirmation checkbox");
        driver.findElement((Locators.CHECKBOX_CONFIRMATION)).click();

        Reports.log("Clean location autofilling form");
        driver.findElement(Locators.AUTOFILLING_FORM_LOCATION).clear();

        Reports.log("Type name of city: " + city);
        driver.findElement(Locators.AUTOFILLING_FORM_LOCATION).sendKeys(city); //input[@name='region_name']


        //After we send city, it detects location

        //No need to add information to this method, we have everything inside, don't need to duplicate steps
        javaWaitSec(3);//tried to fix
        clickValueOfLists(Locators.LIST_VALUE_LOCATION, location); //div[@class='dropdown dropdown_location']//ul//li

    }


    public void testIframeOnMainPage() throws InterruptedException {

        WebElement ele = driver.findElement(Locators.IFRAME);
        ajaxScroll(ele);
        driver.switchTo().frame(ele);
        driver.findElement(Locators.YOUTUBE_PLAY_BUTTON).click();

    }


    public List<WebElement> collectLinks() {

        List<WebElement> list = driver.findElements(Locators.TAB_OF_MAIN_PAGE);
        return list;

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
            javaWaitSec(3);

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

    public int countIframeSize() {
        int size = driver.findElements(By.xpath("//iframe")).size();
        System.out.println(size + " " + "iFrame number");
        return size;
    }

    public void verifyBookNow() {
        WebElement bookNow = (driver.findElement(Locators.BOOK_NOW_TAB));
        assertTrue(bookNow.isDisplayed());
        ajaxClick(Locators.BOOK_NOW_TAB);
        //bookNow.click(); - simple click doesn't work
    }

    public String verifyDiscountAlert() {

        String actualString = driver.findElement(Locators.BOOK_NOW_TAB).getText();
        return actualString;
    }

    public WebElement verifyHeader() {
        WebElement header = driver.findElement(Locators.HEADER_ROMANCE_ABROAD);
        return header;
    }

    public String getErrorMessageFromTooltip() {
        WebElement tooltipMessage = driver.findElement(Locators.TOOLTIP_ERROR);
        String message = tooltipMessage.getText();
        return message;
    }

    public String getValidationMessageForPassword() {
        WebElement tooltipMessage = driver.findElement(Locators.TOOLTIP_ERROR_PASSWORD);
        String message = tooltipMessage.getText();
        return message;
    }


    public void collectLinksWithAssertions() {
        List<WebElement> links = collectLinks();

        for (int i = 0; i < links.size(); i++) {

            String info = links.get(i).getText();
            System.out.println(info);
            links.get(i).click();
            javaWaitSec(3);

            if (info.contains("WORK")) {
                String actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();
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


}

//For myself
// String strEmail = driver.findElement(Locators.TEXT_FIELD_EMAIL).getAttribute("value");
// System.out.println("Email: " + strEmail);

    /* VIDEO 17 Beginning ->  FOR MYSELF NEED CODE BELOW

     public void selectDay(By locator, String text){
        List<WebElement> days = driver.findElements(Locators.LIST_VALUE_DAY);

        for (int i = 0; i < days.size(); i++){
            WebElement day = days.get(i);
            String dayText = day.getText();
            if(dayText.contains(text)){
            day.click();
            }
        }
    }
     */


//OLEKSII QUESTION BELOW:
        /*NE POLUCHILOS to use generator: add dependency + method -> DOBAVILA / shows error
        driver.findElement(Locators.TEXT_FIELD_NICKNAME).sendKeys(generateNewNumber(Data.nickname));*/

        /*
         public void clickSpecificLocation(String location){   // CLICK -> ul/li

        List<WebElement> locations = driver.findElements(By.xpath("//div[@class='dropdown dropdown_location']//ul//li"));
        for (int i = 0; i < locations.size(); i++){
            if(locations.get(i).getText().contains(location)){
                locations.get(i).click();
            }
        }
    }
         */
