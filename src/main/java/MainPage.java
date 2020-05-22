import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class MainPage extends BaseActions {

    //CONSTRUCTOR
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

        // HOW TO OPTIMIZE IT?

        driver.findElement(Locators.TEXT_FIELD_EMAIL).sendKeys(Data.email);
        String strEmail = driver.findElement(Locators.TEXT_FIELD_EMAIL).getAttribute("value");
        System.out.println("Email: " + strEmail);

        driver.findElement(Locators.TEXT_FIELD_PASSWORD).sendKeys(Data.password);
        String strPassword = driver.findElement(Locators.TEXT_FIELD_PASSWORD).getAttribute("value");
        System.out.println("Password: " + strPassword);

        WebElement btnNext = driver.findElement(Locators.BUTTON_NEXT);
        if (btnNext.isDisplayed() && btnNext.isEnabled()) {
            btnNext.click();
            System.out.println("Button" + "Next" + "is displyed and enabled");
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

        WebElement dayEl = driver.findElement(Locators.LIST_VALUE_DAY);
        System.out.println(dayEl.getText());

        // HOW TO PRINT WHICH DAYS, MONTH, YEAR SELECTED
        //GET TEXT?          //*/span[contains(text(),"7")]  How to fetch the text from span tag?
        //NOT SURE HOW TO CREATE SOME VERIFICATION AND PRINT

        /*  *** SENDS THIS :
          public static final String dayOfBirth = "1";
         public static final String monthOfBirth = "May";
         public static final String yearOfBirth = "1995";
         */

        /*
        IN CONSOLE PRINTS THESE:
        Day selected: 1
        Month selected: 0
        Year selected: 2002
         */

        String day = driver.findElement(Locators.LIST_VALUE_DAY).getAttribute("data-value");
        System.out.println("Day selected: " + day);

        driver.findElement(Locators.LIST_MONTHS).click();
        clickValueOfLists(Locators.LIST_VALUE_MONTH, Data.monthOfBirth);

        String month = driver.findElement(Locators.LIST_VALUE_MONTH).getAttribute("data-value");
        System.out.println("Month selected: " + month);

        driver.findElement(Locators.LIST_YEARS).click();
        clickValueOfLists(Locators.LIST_VALUE_YEAR, Data.yearOfBirth);

        String year = driver.findElement(Locators.LIST_VALUE_YEAR).getAttribute("data-value");
        System.out.println("Year selected: " + year);


        WebElement checkbox = driver.findElement((Locators.CHECKBOX_CONFIRMATION));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
      /*  driver.findElement(By.xpath("//div[@id='yearSelect']")).click();

            List<WebElement> elements = driver.findElements(By.xpath("//li[@data-handler='selectYear']"));

            for (int i = 0; i < elements.size(); i++) {
                WebElement elementOfList = elements.get(i);
                String value = elementOfList.getText();
                if (value.contains(Data.yearOfBirth)) {
                    elementOfList.click();
                }
            }*/

    }

    public void testIframeOnMainPage() throws InterruptedException {

        // Video 7 55:31
        Thread.sleep(5000);
        WebElement ele = driver.findElement(Locators.IFRAME);
        //  public static final By IFRAME = By.xpath("//iframe[@src='https://www.youtube.com/embed/RRECuJzm3IY?start=85']");

        ajaxScroll(ele);
        driver.switchTo().frame(ele);
        driver.findElement(Locators.YOUTUBE_PLAY_BUTTON).click();

    }

    // https://www.youtube.com/watch?v=X3LHHhoIwyk

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
        /*
        https://stackoverflow.com/questions/36886825/how-to-convert-a-list-of-webelement-to-another-list-in-the-form-of-string
        List<WebElement> lst=d.findElements(By.tagName("a"));
        List<String> strings = new ArrayList<String>();
        for(WebElement e : lst){
         strings.add(e.getText());
         */

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
        //String info;

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

        int size;
        size = driver.findElements(By.xpath("//iframe")).size();
        System.out.println(size + " " + "iFrame number");
        return size;
    }

    public void navigateToLinkHome() {
        ajaxClick(Locators.LINK_HOME);
    }

    public void verifyBookNow() {
        // ajaxClick(Locators.BOOK_NOW_TAB);

        // Tak pravilno as sert delat?
        //If it's too much code, to chto delat?

        WebElement bookNow = wait.until(ExpectedConditions.visibilityOf(driver.findElement(Locators.BOOK_NOW_TAB)));
        assertTrue(bookNow.isDisplayed()); //ESLI ASSERT IN THE MIDDLE OF TEST CASE, TO OSTAVLYAT V MAIN CLASSE?
        bookNow.click();

    }

    public void verifyDiscountAlert() {

        WebElement discountAlert = wait.until(ExpectedConditions.visibilityOf(driver.findElement(Locators.BOOK_NOW_TAB)));
        assertTrue(discountAlert.isDisplayed());

        //HOW TO DO ASSERTION FOR WEBELEMENT CONTAINS 60% DISCOUNT?

        //   String actualString = driver.findElement(Locators.BOOK_NOW_TAB).getText();
        //  assertTrue(actualString.contains("BOOK NOW "));

        discountAlert.click();

    }
}

