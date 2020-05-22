import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BlogPage extends BaseActions {
    public BlogPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void verifyBlogLinkIsDisplayed() {
        performClick(Locators.LINK_BLOG);
    }
    //OLEKSII PLEASE HELP!!!
    //I WANTED TO ENTER EACH AND EVERY LINK IN THE LIST AND DO ASSERTIONS TO URL, TITLE, AND OTHER ELEMENTS

    public void verifyListNumber() {
        String actualTitle;
        String actualUrlKharkovDatingAgency;
        String info;
        navigateToLinkPage(Locators.LINK_BLOG);
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(Locators.BLOG_LIST)));
        List<WebElement> list = driver.findElements(Locators.BLOG_LIST);
        System.out.println("Size of the list: " + list.size());

        for (int i = 0; i < list.size(); i++) {
            info = list.get(i).getText();
            System.out.println(info);

            //  if (info.toLowerCase().contains("Kharkov dating agency")) {
            if (info.contains("Kharkov dating")) {
                list.get(i).click();
                // YA PYTAUS SDELAT ASSERT POSLE TOGO KAK NASHEL I NAJAL NA 1-I LINK, A ONO DELAET ASSERTION NA SAM BLOG PAGE
                actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();
                actualUrlKharkovDatingAgency = driver.getCurrentUrl();
                Assert.assertEquals(Data.expectedTitleKharkovDatingAgency, actualTitle);
                Assert.assertEquals(Data.expectedUrlKharkovDatingAgency, actualUrlKharkovDatingAgency);

                if (actualUrlKharkovDatingAgency.contains("#")) {
                    Assert.fail("It contains restricted #");
                } else {
                    System.out.println("No special character. It is good url!");
                }
            }
            driver.get(Data.expectedUrlBlog);
            list = driver.findElements(Locators.BLOG_LIST);
        }
    }
}
